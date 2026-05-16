package com.game.engine.state;

import com.game.engine.entities.Enemy;

public class AttackState implements EnemyState {

    @Override
    public void handle(Enemy enemy) {

        System.out.println(enemy.getName() + " is attacking!");

    }
}