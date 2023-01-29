package org.academiadecodigo.bootcamp;

public class Player {
    private String name;
    private Action action;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public Action getAction() {
        return this.action;
    }

    public void chooseAction() {
        int random = (int) Math.round(Math.random() * 2);
        this.action = Action.values()[random];
    }

    public int getScore() {
        return this.score;
    }

    public void wins() {
        this.score++;
    }
}
