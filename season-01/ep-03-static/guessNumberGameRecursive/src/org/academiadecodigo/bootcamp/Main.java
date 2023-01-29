package org.academiadecodigo.bootcamp;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Player marisa = new Player("Marisa");
        Player bernardo = new Player("Bernardo");

        //Player[] players = new Player[Player.getNumOfPlayers()];

        Player[] players = {marisa, bernardo};

        game.gameLoop(players);
    }
}
