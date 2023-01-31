package org.academiadecodigo.wizards;

public class Room {

    private int number;
    private Guest guest;
    private boolean free = true;
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

    public boolean isFree() {
        return free;
    }

    public boolean isClean() {
        return clean;
    }

    public void occupy (Guest guest) {
        this.free = false;
        this.clean = false;
        this.guest = guest;
    }

    public void empty () {
        this.free = true;
        this.guest = null;
    }

    public void clean() {
        this.clean = true;
    }
}
