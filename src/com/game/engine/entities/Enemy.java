package com.game.engine.entities;

import com.game.engine.state.EnemyState;

public class Enemy extends GameEntity {

    private EnemyState state;

    public Enemy(String name, int health, EnemyState state) {

        super(name, health);

        this.state = state;

    }

    @Override
    public void update() {

        state.handle(this);

    }

    public void setState(EnemyState state) {

        this.state = state;

    }
}