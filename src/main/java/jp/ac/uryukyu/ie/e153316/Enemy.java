package jp.ac.uryukyu.ie.e153316;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    public void wounded(int damage) {
        int hp = getHitPoint();
        boolean de = getDead();
        String na = getName();
        hp -= damage;
        setHitPoint(hp);
        if (hp < 0) {
            de = true;
            setDead(de);
            System.out.printf("モンスター%sは倒れた。\n", na);
        }
    }

    public void attack(LivingThing opponent,boolean def){
        int damage = (int)(Math.random() * getAttack());

        if(getDead()){
            damage = 0;
        }
        if(!getDead()) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            } else {
                double lucky = Math.random();
                if (lucky < 0.3) {
                    damage = damage * 2;
                    if (def == true) {  //heroが防御を選んだ時はダメージが半減する
                        damage = damage / 2;
                    }
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                else {
                    if (def == true) {  //heroが防御を選んだ時はダメージが半減する
                        damage = damage / 2;
                    }
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                opponent.wounded(damage);
            }
        }
    }

}