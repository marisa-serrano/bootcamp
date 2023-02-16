package org.academiadecodigo.wizards;

public class Main {

    public static void main(String[] args) {

        FileCopy fileCopy = new FileCopy();

        try {
            fileCopy.copy("resources/File.pdf", "resources/Copy.pdf");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
