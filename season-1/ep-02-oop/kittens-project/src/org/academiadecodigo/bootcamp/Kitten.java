package org.academiadecodigo.bootcamp;

import java.util.Objects;

public class Kitten {

    private String name;
    private String color;
    private String gender;
    private int happiness;
    private int lives;
    private int cuteness;
    private int playfulness;
    private int menace;
    private int energy;
    private Kitten bff;
    private Kitten enemy;
    private String favPerson;

    public Kitten (String name, String color, String gender, int cuteness, int playfulness, int menace) {
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.cuteness = cuteness;
        this.playfulness = playfulness;
        this.menace = menace;
        this.happiness = 100;
        this.lives = 9;
        this.energy = 10;
    }

    public int getHappiness() {return happiness;}
    public int getLives() {return lives;}
    public int getEnergy() {return energy;}
    public String getBff() {return bff.name;}
    public Kitten getEnemy() {return enemy;}
    public String getFavPerson() {return favPerson;}

    public void setBff (Kitten bff) {
        this.bff = bff;
    }

    public void setEnemy (Kitten enemy) {
        this.enemy = enemy;
    }

    public void setFavPerson (String person) {
        this.favPerson = person;
    }

    public void meow() {
        System.out.println("Meow!");
    }

    public void eat (String food) {
        energy += 3;
        happiness += 3;
        System.out.println(name + " is eating " + food);
    }

    public void sleep() {
        energy += 7;
        System.out.println(name + " is sleeping");
    }

    public void play() {
        happiness += playfulness;
        energy -= 1;
        System.out.println(name + " is playing!");
    }

    public void playWith (Kitten other) {
        this.happiness += other.playfulness;
        other.happiness += this.playfulness;
        this.energy -= 2;
        other.energy -= 2;
        System.out.println(this.name + " and " + other.name + " are playing!");
    }

    public void cuddleWith (Kitten other) {
        System.out.println(this.name + " and " + other.name + " are cuddling");
        this.happiness += other.cuteness;
        other.happiness += this.cuteness;

        if (Objects.equals(this.bff, other) && Objects.equals(other.bff, this)) {
            this.happiness += 7;
            other.happiness += 7;

        } else if (Objects.equals(this.bff, other)) {
            this.happiness += 5;

        } else if (Objects.equals(other.bff, this)) {
            other.happiness += 5;
        }
    }

    public void fightWith (Kitten other) {
        System.out.println(this.name + " and " + other.name + " are fighting.");

        Kitten winner = headToHead(this, other);
        Kitten loser = (winner.equals(this)) ? other : this;

        loser.lives -= 1;
        loser.happiness -= 50;
        winner.happiness -= 45;
        this.energy -= 10;
        other.energy -= 10;

        if (Objects.equals(winner.enemy, loser) && Objects.equals(loser.enemy, winner)) {
            winner.happiness += 10;
            loser.happiness -= 10;

        } else if (Objects.equals(winner.enemy, loser)) {
            winner.happiness += 5;

        } else if (Objects.equals(loser.enemy, winner)) {
            loser.happiness -= 5;
        }

        System.out.println(winner.name + " won and " + loser.name + " has " + loser.lives + " lives left.");
    }

    public Kitten headToHead (Kitten one, Kitten two) {
        int score1 = one.menace + one.energy - one.cuteness;
        int score2 = two.menace + two.energy - two.cuteness;

        if (Objects.equals(one.bff, two) && !Objects.equals(two.bff, one)) {
            score1 -= 3;

        } else if (Objects.equals(two.bff, one) && !Objects.equals(one.bff, two)) {
            score2 -= 3;

        } else if (Objects.equals(one.enemy, two) && !Objects.equals(two.enemy, one)) {
            score1 += 3;

        } else if (Objects.equals(two.enemy, one) && !Objects.equals(one.enemy, two)) {
            score2 += 3;
        }

        Kitten winner = (score1 >= score2) ? one : two;
        return winner;
    }
}