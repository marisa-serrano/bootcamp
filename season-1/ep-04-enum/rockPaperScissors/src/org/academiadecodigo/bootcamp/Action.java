package org.academiadecodigo.bootcamp;

public enum Action {
        ROCK,
        PAPER,
        SCISSORS;


        public static Player getWinner(Player player1, Player player2) {
                Player winner = player1;

                if (player2.getAction() == Action.PAPER && player1.getAction() == Action.ROCK || player2.getAction() == Action.SCISSORS && player1.getAction() == Action.PAPER || player2.getAction() == Action.ROCK && player1.getAction() == Action.SCISSORS) {
                        winner = player2;
                }

                winner.wins();
                return winner;
        }
}

