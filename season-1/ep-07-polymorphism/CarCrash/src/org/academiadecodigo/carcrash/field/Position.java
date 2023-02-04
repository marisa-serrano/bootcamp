package org.academiadecodigo.carcrash.field;

public class Position {
    private static int maxRow = Field.getHeight();
    private static int maxCol = Field.getWidth();
    private int currentRow;
    private int currentCol;
    private int nextRow;
    private int nextCol;
    private String lastMove = "col";

    public Position(){
        currentRow = (int) (Math.random() * (maxRow));
        currentCol = (int) (Math.random() * (maxCol));
        generateNextPosition();
    }

    public void generateNextPosition(){
        nextRow = (int) (Math.random() * (maxRow));
        nextCol = (int) (Math.random() * (maxCol));
    }

    public void moveLast(){
        if (lastMove.equals("row")) {
            moveRow();

        } else {
            moveCol();
            lastMove = "col";
        }
    }

    public void moveOther(){
        if (lastMove.equals("row")) {
            moveCol();

        } else {
            moveRow();
            lastMove = "row";
        }
    }

    public void moveRow(){
        if (currentRow < nextRow){
            currentRow++;

        } else {
            currentRow--;
        }
    }

    public void moveCol(){
        if (currentCol < nextCol){
            currentCol++;

        } else {
            currentCol--;
        }
    }

    public void setNextPosition(int row, int col){
        nextRow = row;
        nextCol = col;
    }
    public int getRow() {
        return currentRow;
    }
    public int getCol() {
        return currentCol;
    }
    public int getNextRow(){
        return nextRow;
    }
    public int getNextCol(){
        return nextCol;
    }
}
