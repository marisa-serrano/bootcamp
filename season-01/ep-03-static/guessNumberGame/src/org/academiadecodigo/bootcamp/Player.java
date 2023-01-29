package org.academiadecodigo.bootcamp;

public class Player {
    private String name;
    private Number guess;
    private int[] alreadyGuessed = new int[21];

    public Player(String name) {
        this.name = name;
        this.guess = new Number();
        for (int i = 0; i < this.alreadyGuessed.length; i++) {
            this.alreadyGuessed[i] = 0;
        }
    }

    public int getPlayerGuess() {
        return this.guess.getNumber();
    }

    public String getName() {
        return this.name;
    }

    public void updateGuess() {
        this.alreadyGuessed[this.getPlayerGuess()]++;
        this.guess.updateNumber();
        while (this.alreadyGuessed[this.getPlayerGuess()] == 1) {
            this.guess.updateNumber();
        }
    }




}
