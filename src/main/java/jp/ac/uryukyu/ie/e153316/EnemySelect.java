package jp.ac.uryukyu.ie.e153316;
import java.util.Scanner;

public class EnemySelect {
    private String name;
    private int HP;
    private int attack;

    public EnemySelect() {
        System.out.println("戦うモンスターを選択してください");
        System.out.println("0. おまかせ");
        System.out.println("1. スライム");
        System.out.println("2. がいこつ");
        System.out.println("3. キメラ");
        System.out.println("4. ゴーレム");
        select();
    }

    public void select(){
        try {
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            switch (str) {
                case "０":
                case "0":
                    randomselect();
                    break;
                case "１":
                case "1":
                    set("スライム", 3, 5);
                    break;
                case "２":
                case "2":
                    set("がいこつ", 30, 28);
                    break;
                case "３":
                case "3":
                    set("キメラ", 42, 56);
                    break;
                case "４":
                case "4":
                    set("ゴーレム", 70, 120);
                    break;
                default:
                    System.out.println(" 数字を選んで入力しよう。");
                    select();
            }
        }
        catch (Exception e){select();} //入力で例外が発生した場合は再びselectメソッドを呼び出し
    }

    public void set(String selectedname,int enemyHP,int enemyattack){
        this.name = selectedname;
        this.HP = enemyHP;
        this.attack = enemyattack;
    }

    public void randomselect(){
        int selectnumber = (int)(1 + Math.random()*4);
        if(selectnumber==1){set("スライム",3,5);}
        else if (selectnumber==2){set("がいこつ",30,28);}
        else if (selectnumber==3){set("キメラ",42,56);}
        else if (selectnumber==4){set("ゴーレム",70,120);}
    }

    public String getName(){return this.name;}
    public int getHP(){ return this.HP;}
    public int getAttack(){ return this.attack;}
}
