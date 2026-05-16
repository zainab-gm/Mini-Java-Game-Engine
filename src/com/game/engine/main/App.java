package com.game.engine.main;

import com.game.engine.entities.Player;
import com.game.engine.entities.Enemy;
import com.game.engine.factory.EnemyFactory;
import com.game.engine.state.AttackState;

import com.game.engine.observer.GameObserver;
import com.game.engine.observer.GameSubject;

public class App {

    public static void main(String[] args) {

        Player player = new Player("Knight", 150);

        Enemy enemy = EnemyFactory.createEnemy("Zombie");

        player.update();

        enemy.update();

        enemy.setState(new AttackState());

        enemy.update();

        GameSubject subject = new GameSubject();

        GameObserver observer = new GameObserver("Console Logger");

        subject.addObserver(observer);

        subject.notifyObservers("Enemy Spawned");

    }
}