package org.academiadecodigo.wizards;

public class Main {
    public static void main(String[] args) {

        Guest anna = new Guest("Anna", "female");
        Guest john = new Guest("John", "male");
        Guest bob = new Guest("Bob", "male");

        Hotel tivoli = new Hotel("Tivoli", 7);

        tivoli.showRooms();

        tivoli.checkIn(anna);
        tivoli.showRooms();

        tivoli.checkOut(john);
        tivoli.checkIn(anna);

        tivoli.checkIn(john);
        tivoli.checkIn(bob);
        tivoli.checkOut(anna);
        tivoli.showRooms();

        tivoli.clean();
        tivoli.showRooms();
    }
}
