package org.academiadecodigo.carcrash.cars;

public class Ambulance extends Car{

    public Ambulance(int row, int col){
        super();
        this.getPos().setNextPosition(row, col);
    }

    @Override
    public String toString(){
        if (isCrashed()){
            return "C";
        }
        return "A";
    }
}
