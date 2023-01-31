package org.academiadecodigo.wizards;

public class Room {

    private int number;
    private Guest guest;
    private boolean empty = true;
    private boolean clean = true;

    public Room (int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isClean() {
        return clean;
    }

    public void occupy (Guest guest) {
        this.empty = false;
        this.clean = false;
        this.guest = guest;
    }

    public void empty () {
        this.empty = true;
        this.guest = null;
    }

    public void clean() {
        this.clean = true;
    }
}
