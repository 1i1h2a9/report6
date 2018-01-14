package jp.ac.uryukyu.ie.e153316;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    public void testattack() {
        int enemyHP = 6;
        Hero hero = new Hero("テスト勇者", 10, 5);
        Enemy enemy = new Enemy("テストスライム",enemyHP, 3);
        hero.setDead(true);
        for(int i=0; i<10; i++) {
            hero.attack(enemy); //乱数で0ダメージとなることもあるため、複数回実行してみる。
        }
        assertEquals (enemyHP, enemy.getHitPoint());
    }

}