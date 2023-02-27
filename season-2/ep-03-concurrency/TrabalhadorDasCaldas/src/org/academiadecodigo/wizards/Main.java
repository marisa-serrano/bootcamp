package org.academiadecodigo.wizards;

public class Main {

    public static void main(String[] args) {

        Thread trabalhador = new Thread(new TrabalhadorDasCaldas());
        trabalhador.start();

        try {
            System.out.println("Gerente: À espera que os trabalhadores acabem...");

            // join() faz a main esperar enquanto a thread do trabalhador acaba de ser executada
            // ajuda-nos a gerir o comportamento das threads
            trabalhador.join();
            System.out.println("Gerente: Finalmente acabaram, vou para casa!");

        } catch (InterruptedException e) {
            System.out.println("Gerente: acordaram-me da sesta mas ainda não acabaram");
            e.printStackTrace();
        }
    }
}