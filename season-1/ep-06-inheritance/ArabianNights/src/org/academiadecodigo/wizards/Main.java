package org.academiadecodigo.wizards;

public class Main {
    public static void main(String[] args) {

        MagicLamp lamp = new MagicLamp(5);
        Person person = new Person(lamp);

        //person.rubLamp();
        person.askWishes();

    }

}
