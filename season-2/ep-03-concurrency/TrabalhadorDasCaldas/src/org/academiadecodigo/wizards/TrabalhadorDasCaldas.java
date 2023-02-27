package org.academiadecodigo.wizards;

public class TrabalhadorDasCaldas implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Trabalhador das Caldas: aqui a fazer uma loiça");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Estava a dormir, mas acordaram-me");
                e.printStackTrace();
            }
        }

        System.out.println("Trabalhador das Caldas: Não faço nem mais um c...");
    }
}