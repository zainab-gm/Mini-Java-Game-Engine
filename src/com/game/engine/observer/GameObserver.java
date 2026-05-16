package com.game.engine.observer;

public class GameObserver implements Observer {

    private String observerName;

    public GameObserver(String observerName) {

        this.observerName = observerName;
    }

    @Override
    public void update(String message) {

        System.out.println(
                observerName + " received event: " + message);
    }
}