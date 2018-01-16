package jp.ac.uryukyu.ie.e153316;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    private int initHP;

    public LivingThing (String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        initHP = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public String getName(){
        return name;
    }

    public void attack(LivingThing opponent){
        String name = opponent.getName();
        int damage = (int)(Math.random() * attack);
        if(dead){ damage = 0; }
        if(!dead) { System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage); }
        opponent.wounded(damage);
    }

    //ダメージをうけてHPがへるメソッド。HPが0以下なら死亡判定をだす
    public void wounded(int damage) {
        String name = getName();
        int hp = getHitPoint();
        hp -= damage;
        setHitPoint(hp);
        if (hp <= 0) {
            setDead(true);
            if (name == "勇者"){ System.out.printf("%sは道半ばで力尽きてしまった。\n", name); }
            else{System.out.printf("モンスター%sは倒れた。。\n", name);}
        }
    }

    public int getHitPoint(){ return hitPoint; }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public boolean getDead(){ return dead; }

    public void setDead(boolean dead){ this.dead = dead; }

    public int getAttack() { return attack; }

    public int getinitHP(){ return initHP; }

}


