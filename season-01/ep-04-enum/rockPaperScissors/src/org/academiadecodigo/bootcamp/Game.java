package org.academiadecodigo.bootcamp;

public class Game {
    private int numOfRounds;

    public static void start(Player player1, Player player2, int numOfRounds) {

        for (int i = 0; i < numOfRounds; i++) {
            player1.chooseAction();
            player2.chooseAction();
            System.out.println(player1.getName() + " picked " + player1.getAction());
            System.out.println(player2.getName() + " picked " + player2.getAction());

            if (player1.getAction() == player2.getAction()) {
                System.out.println("Both players picked the same object. It's a tie.");
                player1.wins();
                player2.wins();

            } else {
                Player winner = Action.getWinner(player1, player2);
                System.out.println(winner.getName() + " won this round!");
            }
        }

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " won!");

        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " won!");

        } else {
            System.out.println("It's a draw!");
        }

        System.out.println("# Game ended #");

    }
}
