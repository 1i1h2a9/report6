package jp.ac.uryukyu.ie.e153316;
import java.util.Scanner;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    //ダメージをうけてHPがへるメソッド。HPが0以下なら死亡判定をだす
    public void wounded(int damage) {
        int hp = getHitPoint();
        boolean de = getDead();
        String na = getName();
        hp -= damage;
        setHitPoint(hp);
        if (hp < 0) {
            de = true;
            setDead(de);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", na);
        }
    }

    //敵にダメージを与えるメソッド。40%の確率で2倍のダメージが与えられる。
    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * getAttack());

        if(getDead()){
            damage = 0;
        }
        if(!getDead()) {
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }
            else {
                double lucky = Math.random();
                if (lucky <0.4){
                    damage = damage*2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
            }
        }
        opponent.wounded(damage);
    }

    //選択肢を選ばせて、選択された処理を行うメソッド
    public String select(LivingThing opponent) {
        System.out.println(" 1. こうげき");
        System.out.println(" 2. にげる");
        System.out.println(" 3. ぼうぎょ");
        System.out.println(" 4. どうぐ");

        Scanner scan = new Scanner(System.in);

        String str = scan.next();

        switch (str) {
            case "1":
                System.out.println(" こうげき");
                attack(opponent);
                return "attack";
            case "2":
                System.out.println(" にげる");
                String judgment = escapejudgment();
                return judgment;
            case "3":
                System.out.println(" ぼうぎょ");
                System.out.printf("%sは　みをまもっている！\n", getName());
                return "defense";
            case "4":
                System.out.println(" どうぐ");
                return "tool";
            default:
                System.out.println(" 数字を選んで入力しよう。");
                select(opponent); //選択肢以外が入力されたらやり直し
                return "default";
        }
    }

    //にげるコマンドの判定メソッド。30%の確率で逃げられる。
    public String escapejudgment(){
        double odds = Math.random();
            if (odds < 0.3){
                System.out.printf("%sは にげだした！\n" , getName());
                return "escape";
            }
            else{
                System.out.printf("%sは にげだした！\nしかし まわりこまれてしまった！\n" , getName());
                return "miss";
            }
    }
}

