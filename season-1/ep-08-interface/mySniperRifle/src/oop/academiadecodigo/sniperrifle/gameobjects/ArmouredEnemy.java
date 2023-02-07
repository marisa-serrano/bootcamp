package oop.academiadecodigo.sniperrifle.gameobjects;

import oop.academiadecodigo.sniperrifle.gameobjects.Enemy;

public class ArmouredEnemy extends Enemy {


    private int armour = 100;

    public void hit(int damage){
        if (armour >= damage){
            armour -= damage;
            System.out.println(this.getMessage() + " has gotten his armour reduced by " + damage);

        } else if (armour > 0){
            int leftoverDamage = Math.abs(armour - damage);
            armour = 0;
            System.out.println(this.getMessage() + " has lost his armour");
            super.hit(leftoverDamage);


        } else {
            super.hit(damage);
        }
    }

    public String getMessage(){
        return "Armoured enemy";
    }
}
