package org.academiadecodigo.carcrash.cars;

public class Citroen extends Car{
    private int turn;
    public Citroen(){
        super();
    }

    public void move(){
       if (turn == 2) {
           super.move();
           turn = 0;

       } else {
           turn++;
       }
    }

    public String toString(){
        return "C";
    }
}
