package org.academiadecodigo.wizards;

public class Guest {

    private final String name;
    private final String gender;
    private final String pronoun;
    private boolean checkedIn;
    private Room room;
    public Guest (String name, String gender) {
        this.name = name;
        this.gender = gender;

        switch (gender) {
            case "male":
                this.pronoun = "he";
                break;
            case "female":
                this.pronoun = "she";
                break;
            default:
                this.pronoun = "they";
        }
    }
    public String getName() {
        return name;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setCheckedIn(boolean value, Room room) {
        this.room = room;
        this.checkedIn = value;
    }

    public Room getRoom() {
        return this.room;
    }

    public boolean isCheckedIn() {
        return this.checkedIn;
    }
}
