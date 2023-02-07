package oop.academiadecodigo.sniperrifle;

public class SniperRifle {

    private int bulletDamage = 50;


    public void shoot(Shootable enemy){
        int chanceOfHitting = (int) (Math.random() * 2);
        int chanceOfCritting = (int) (Math.random() * 10);
        System.out.println("Sniper has fired a shot.");
        if (chanceOfHitting == 0){
            if(chanceOfCritting == 1){
                System.out.println("Critical shot!!!!");
                enemy.hit(bulletDamage * 2);
            }else{
                enemy.hit(bulletDamage);
            }


        } else {
            System.out.println("Missed shot.");
        }
    }
}
