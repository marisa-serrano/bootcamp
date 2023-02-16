package org.academiadecodigo.bootcamp.gfx.simplegfx;


import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid grid;
    private int RowPx;
    private int ColPx;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.grid = grid;
        this.RowPx = (getRow() * grid.getCellSize()) + grid.getCellSize();
        this.ColPx = (getCol() * grid.getCellSize()) + grid.getCellSize();
        rectangle = new Rectangle(RowPx, ColPx, grid.getCellSize(), grid.getCellSize());
        rectangle.draw();

        //rectangle = new Rectangle(getCol(), getRow(), getCol() + simpleGfxGrid.getCellSize(), getRow() + simpleGfxGrid.getCellSize());
        //throw new UnsupportedOperationException();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        this.grid = grid;
        this.RowPx = (super.getRow() * grid.getCellSize());
        this.ColPx = (super.getCol() * grid.getCellSize());
        rectangle = new Rectangle(RowPx + SimpleGfxGrid.PADDING, ColPx + SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());
        rectangle.draw();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        int initialRow = this.getRow();
        int initialCol = this.getCol();

        super.moveInDirection(direction, distance);
        rectangle.translate((this.getRow() - initialRow) * grid.getCellSize(), (this.getCol() - initialCol) * grid.getCellSize());
        //throw new UnsupportedOperationException();
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(color.getColor());
    }
}
