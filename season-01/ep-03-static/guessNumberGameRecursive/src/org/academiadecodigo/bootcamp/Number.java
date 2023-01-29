package org.academiadecodigo.bootcamp;

public class Number {
    private int number;

    public Number() {
        this.number = (int) Math.round(Math.random() * 20);
    }

    public int getNumber() {
        return this.number;
    }

    public void updateNumber() {
        this.number = (int) Math.round(Math.random() * 20);
    }
}
