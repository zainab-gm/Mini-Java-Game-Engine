package com.game.engine.state;

import com.game.engine.entities.Enemy;

public interface EnemyState {

    void handle(Enemy enemy);

}