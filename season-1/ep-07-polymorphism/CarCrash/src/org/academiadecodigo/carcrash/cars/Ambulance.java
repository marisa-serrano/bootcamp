package org.academiadecodigo.carcrash.cars;
import org.academiadecodigo.carcrash.Game;

public class Ambulance extends Car{

    public Ambulance(int row, int col){
        super();
        this.getPos().setNextPosition(row, col);
    }

    @Override
    public void move(){
        if (this.getPos().rowEquals(this.getPos().getNextRow())){
            if (this.getPos().colEquals(this.getPos().getNextCol())) {
                Game.uncrash();
                move();
            } else {
                this.pos.moveCol();
            }

        } else if (this.pos.getCol() == this.pos.getNextCol()){
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

    @Override
    public String toString(){
        if (isCrashed()){
            return "C";
        }
        return "A";
    }
}
