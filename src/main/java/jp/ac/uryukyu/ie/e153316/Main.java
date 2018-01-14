package jp.ac.uryukyu.ie.e153316;

public class Main {
    public static void main(String[] args){
        Hero hero = new Hero("勇者", 20, 5);
        Enemy enemy = new Enemy("スライム", 12, 3);

        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( hero.isDead() == false && enemy.isDead() == false ){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            String s = hero.select(enemy);
            if (s == "escape"){break;}
            enemy.attack(hero);
        }
        System.out.println("戦闘終了");
    }

}
