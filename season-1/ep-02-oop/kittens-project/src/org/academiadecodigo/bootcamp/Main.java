package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        Kitten betty = new Kitten ("Betty", "white", "female", 8, 5, 2);
        Kitten jack = new Kitten ("Jack", "black", "male", 2, 8, 7);
        Kitten misty = new Kitten ("Misty", "grey", "female", 10, 10, 5);

        /*
        betty.playWith(misty);
        System.out.println("Betty's happiness: " + betty.getHappiness());
        System.out.println("Misty's happiness: " + misty.getHappiness());

        jack.play();

        betty.cuddleWith(misty);
        System.out.println("Betty's happiness: " + betty.getHappiness());
        System.out.println("Misty's happiness: " + misty.getHappiness());

        betty.fightWith(misty);
        System.out.println("Misty's happiness: " + misty.getHappiness());

        misty.sleep();
        betty.meow();

        jack.eat("watermelon");
        System.out.println("Jack's energy: " + jack.getEnergy());
*/
        jack.setBff(misty);
        misty.setBff(jack);
        System.out.println(jack.getBff());

        System.out.println("Misty's happiness: " + misty.getHappiness());
        System.out.println("Jack's happiness: " + jack.getHappiness());

        jack.cuddleWith(misty);
        System.out.println("Misty's happiness: " + misty.getHappiness());
        System.out.println("Jack's happiness: " + jack.getHappiness());

        System.out.println(misty.getLives());

        jack.fightWith(misty);

    }
}
