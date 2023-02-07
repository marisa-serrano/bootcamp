package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private boolean crashed;

    public Car(){
        pos = new Position();
    }

    public void crash(){
        crashed = true;
    }

    public void uncrash(){
        crashed = false;
    }

    public void move(){
        if (this.pos.rowEquals(this.pos.getNextRow())){
            if (this.pos.colEquals(this.pos.getNextCol())) {
                this.pos.generateNextPosition();
                move();
            } else {
                this.pos.moveCol();
            }

        } else if (this.pos.colEquals(this.pos.getNextCol())){
            this.pos.moveRow();

        } else {
            int i = (int) (Math.random() * 10);
            if (i < 9){
                this.pos.moveLast();
            } else {
                this.pos.moveOther();
            }
        }
    }

    public Position getPos() {
        return pos;
    }

    public int getRow(){
        return this.pos.getRow();
    }

    public int getCol(){
        return this.pos.getCol();
    }

    public boolean isCrashed() {
        return crashed;
    }
}
