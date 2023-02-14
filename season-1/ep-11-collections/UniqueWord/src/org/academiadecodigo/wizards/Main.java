package org.academiadecodigo.wizards;

import sun.security.x509.UniqueIdentity;

public class Main {

    public static void main(String[] args) {

        String STRING = "Coder girls are are are the the best girls";

        UniqueWord wc = new UniqueWord(STRING);
        for (String word : wc) {
            System.out.println(word);
        }
    }
}
