package org.academiadecodigo.wizard;

public class Main {
    public static void main(String[] args) {

        try {
            WordReader wordReader = new WordReader("Resources/Word_Read.txt");
            for (String word : wordReader) {
                System.out.println(word);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}