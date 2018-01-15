package jp.ac.uryukyu.ie.e153316;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;



class HeroTest {
    @Test
    // heroが死んだ状態でenemyを攻撃できないかどうか確認する
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

    @Test
    // heroに4ダメージを与えたあと、どうぐのやくそうを使ってHPが上限まで回復しているのか確認する
    public void testtools(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        int initHP = 10;
        Hero hero = new Hero("テスト勇者", initHP, 5);
        Enemy enemy = new Enemy("テストスライム",6, 3);
        hero.wounded(4);
        assertEquals (6, hero.getHitPoint()); //4ダメージうけたのでHPが6になっているか確認する
        hero.tools();
        System.setIn(System.in);
        assertEquals (initHP, hero.getHitPoint()); //やくそうを使ったので体力がHPが上限まで回復しているのか確認する
    }

}