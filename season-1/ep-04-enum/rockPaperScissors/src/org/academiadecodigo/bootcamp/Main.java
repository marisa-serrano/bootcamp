package org.academiadecodigo.bootcamp;

public class Main {
    public static void main(String[] args) {

        Player bernardo = new Player("Bernardo");
        Player marisa = new Player("Marisa");

        Game.start(bernardo, marisa, 3);
    }
}
