package com.game.engine.state;

import com.game.engine.entities.Enemy;

public class IdleState implements EnemyState {

    @Override
    public void handle(Enemy enemy) {

        System.out.println(enemy.getName() + " is idle.");

    }
}