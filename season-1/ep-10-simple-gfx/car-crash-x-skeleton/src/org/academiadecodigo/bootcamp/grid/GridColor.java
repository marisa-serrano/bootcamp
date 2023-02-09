package org.academiadecodigo.bootcamp.grid;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.awt.*;

/**
 * The available grid colors
 */
public enum GridColor {

    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    MAGENTA(Color.MAGENTA),
    NOCOLOR(Color.WHITE);

    Color color;

    GridColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
}
