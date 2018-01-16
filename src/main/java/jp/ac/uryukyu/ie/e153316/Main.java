package jp.ac.uryukyu.ie.e153316;

public class Main {
    public static void main(String[] args){
        EnemySelect select = new EnemySelect();
        Hero hero = new Hero("勇者", 150, 10);
        Enemy enemy = new Enemy(select.getName(), select.getHP(), select.getAttack());
        boolean defense;

        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( hero.isDead() == false && enemy.isDead() == false ){
            turn++;
            defense = false;
            System.out.printf("%dターン目開始！\n", turn);
            System.out.printf("%sのHP = %d\n",hero.getName(),hero.getHitPoint());
            String s = hero.select(enemy);
            if (s == "escape"){break;}
            else if(s == "defense"){defense = true;}
            else{}
            enemy.attack(hero,defense);
        }
        System.out.println("戦闘終了");
    }

}
