package org.academiadecodigo.wizards;

public class Fighter {

    private int strength;
    private int health;
    private boolean alive;

    public Fighter(int strength, int health, boolean alive) {
        this.strength = strength;
        this.health = health;
        this.alive = alive;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }
}
