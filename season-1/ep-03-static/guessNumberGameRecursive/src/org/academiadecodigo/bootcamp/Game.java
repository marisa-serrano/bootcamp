package org.academiadecodigo.bootcamp;

public class Game {
    private Number numToGuess;
    private static int numGuessed;
    private int tries;


    public Game() {
        this.numToGuess = new Number();
        numGuessed = 0;
        this.tries = 1;
    }

    public void start() {
        System.out.println("# The game has started. The number to guess is: " + this.numToGuess.getNumber() + " #");
    }

    public void round(Player[] players, int i) {
        if (players[i].getPlayerGuess() == this.numToGuess.getNumber() && this.tries <= 5) {
            System.out.println(players[i].getName() + " guessed correctly: " + players[i].getPlayerGuess());

        } else if (this.tries <= 5) {
            System.out.println(players[i].getName() + " guessed incorrectly: " + players[i].getPlayerGuess());
            players[i].updateGuess();
            i++;

            if (i >= players.length) {
                i = 0;
                this.tries++;
            }

            round(players, i);

        } else {
            System.out.println("Players ran out of tries");
        }
    }

    public void gameLoop(Player[] players) {
        start();
        round(players, 0);
        System.out.println("# Game ended! #");
    }
}
