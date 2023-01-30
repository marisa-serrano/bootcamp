package org.academiadecodigo.bootcamp;

public enum Action {
        ROCK,
        PAPER,
        SCISSORS;


        public static Player getWinner(Player player1, Player player2) {
                Player winner = player1;
                Action p1Action = player1.getAction();
                Action p2Action = player2.getAction();

                if (p2Action == Action.PAPER && p1Action == Action.ROCK || p2Action == Action.SCISSORS && p1Action == Action.PAPER || p2Action == Action.ROCK && p1Action == Action.SCISSORS) {
                        winner = player2;
                }

                winner.wins();
                return winner;
        }
}

