package org.academiadecodigo.wizards;

public class Main {
    public static void main(String[] args) {

        Guest anna = new Guest("Anna", "female");
        Guest john = new Guest("John", "male");
        Guest don = new Guest("Don", "male");

        Hotel tivoli = new Hotel("Tivoli", 7);

        tivoli.showRooms();

    }
}
