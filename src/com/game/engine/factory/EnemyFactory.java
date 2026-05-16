package com.game.engine.factory;

import com.game.engine.entities.Enemy;
import com.game.engine.state.IdleState;

public class EnemyFactory {

    public static Enemy createEnemy(String type) {

        if(type.equals("Zombie")) {

            return new Enemy("Zombie", 100, new IdleState());

        }

        else if(type.equals("Skeleton")) {

            return new Enemy("Skeleton", 80, new IdleState());

        }

        return null;
    }
}