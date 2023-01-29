package org.academiadecodigo.bootcamp;

public class Main {
    public static void main(String[] args) {

        Player marisa = new Player("Marisa");
        Player bernardo = new Player("Bernardo");

        Player[] players = new Player[2];
        players[0] = marisa;
        players[1] = bernardo;

        Game game = new Game();

        game.gameLoop(players);

    }
}
