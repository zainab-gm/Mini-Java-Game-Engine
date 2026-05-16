package com.game.engine.entities;

public class Player extends GameEntity {

    public Player(String name, int health) {

        super(name, health);

    }

    @Override
    public void update() {

        System.out.println(name + " is moving.");

    }
}
