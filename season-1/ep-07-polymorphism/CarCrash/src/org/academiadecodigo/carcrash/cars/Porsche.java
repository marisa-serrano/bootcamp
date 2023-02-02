package org.academiadecodigo.carcrash.cars;

public class Porsche extends Car{

    private int turn;
    public Porsche(){
        super();
    }

    public void move(){
        if (turn == 1) {
            super.move();
            turn = 0;

        } else {
            turn++;
        }
    }

    public String toString(){
        if (isCrashed()) {
            return "C";
        }
        return "P";
    }
}
