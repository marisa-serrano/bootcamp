package org.academiadecodigo.bootcamp;

public class Game {
    private Number numToGuess;
    private static int numGuessed;


    public Game() {
        this.numToGuess = new Number();
        numGuessed = 0;
    }

    public void start() {
        System.out.println("# The game has started. The number to guess is: " + this.numToGuess.getNumber() + " #");
    }

    public void gameLoop(Player[] players) {
        start();
        int tries = 1;
        while (numGuessed == 0 && tries <= 5) {
            for (Player player : players) {
                if (player.getPlayerGuess() == numToGuess.getNumber()) {
                    System.out.println(player.getName() + " guessed correctly: " + player.getPlayerGuess());
                    numGuessed++;
                    break;

                } else if ((player.getPlayerGuess() != numToGuess.getNumber()) && tries <= 5) {
                    System.out.println(player.getName() + " guessed incorrectly: " + player.getPlayerGuess());
                    player.updateGuess();

                }
            }
           tries++;
        }

        if (numGuessed == 0) {
            System.out.println("Players ran out of tries.");
        }

        System.out.println("# Game ended! #");
    }
}
