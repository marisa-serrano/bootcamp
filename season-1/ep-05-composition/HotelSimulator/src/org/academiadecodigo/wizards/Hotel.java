package org.academiadecodigo.wizards;

public class Hotel {

    private String name;
    private int numOfRooms;
    private int freeRooms;
    private int numOfGuests;
    private Room[] rooms;

    public Hotel (String name, int numOfRooms) {
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.freeRooms = numOfRooms;
        this.rooms = new Room[numOfRooms];

        for (int i = 0; i < numOfRooms; i++) {
            rooms[i] = new Room(i+1);
        }
    }

    public void checkIn (Guest guest) {

        if (freeRooms == 0) {
            System.out.println("Sorry, " + guest.getName() + " can't check in because there are no available rooms.");

        } else if (guest.isCheckedIn()) {
            System.out.println(guest.getName() + " has already checked in.");

        } else {
            checkInProcess(guest);
        }
    }

    public void checkOut (Guest guest) {

        if (!guest.isCheckedIn()) {
            System.out.println(guest.getName() + " can't check out because " + guest.getPronoun() + " isn't checked in.");

        } else {
            checkOutProcess(guest);
        }
    }

    private void checkInProcess (Guest guest) {
        for (Room room : rooms) {
            if (room.isFree() && room.isClean()) {
                room.occupy(guest);
                freeRooms--;
                guest.setCheckedIn(true, room);
                numOfGuests++;
                System.out.println(guest.getName() + " checked in to room " + room.getNumber() + ".");
                break;
            }
        }
    }

    private void checkOutProcess (Guest guest) {
        guest.getRoom().empty();
        guest.setCheckedIn(false, null);
        numOfGuests--;
        System.out.println(guest.getName() + " checked out.");
    }

    public void clean () {
        for (Room room : rooms) {
            if (!room.isClean() && room.isFree()) {
                room.clean();
                freeRooms++;
                System.out.println("Room " + room.getNumber() + " was cleaned and is now available.");
            }
        }
    }

    public void showRooms () {
        System.out.println("-----------------------------------------");
        for (Room room : rooms) {
            if (!room.isFree()) {
                System.out.println("Room " + room.getNumber() + " - Status: Occupied, Guest: " + room.getGuest().getName());

            } else {
                System.out.println("Room " + room.getNumber() + " - Status: Vacant, Clean: " + room.isClean());
            }
        }
        System.out.println("-----------------------------------------");
    }
}
