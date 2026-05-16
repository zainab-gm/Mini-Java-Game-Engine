package com.game.engine.entities;

public abstract class GameEntity {

    protected String name;
    protected int health;

    public GameEntity(String name, int health) {

        this.name = name;
        this.health = health;

    }

    public abstract void update();

    public String getName() {

        return name;

    }

    public int getHealth() {

        return health;

    }
}