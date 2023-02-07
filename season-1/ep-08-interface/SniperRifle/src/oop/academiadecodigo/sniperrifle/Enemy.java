package oop.academiadecodigo.sniperrifle;

public abstract class Enemy extends GameObject implements Shootable{

    private int health = 100;

    private boolean isDead;

    public boolean isDead(){
        return isDead;
    }
    public void hit(int damage){
        if(isDead){
            return;
        }
        health -= damage;
        System.out.println(this.getMessage() + " lost " + damage + " health");
        if (health <= 0){
            isDead = true;
            System.out.println(this.getMessage() + " has died :(");
        }
    }

    public abstract String  getMessage();

    @Override
    public boolean isShootable() {
        return !isDead;
    }
}
