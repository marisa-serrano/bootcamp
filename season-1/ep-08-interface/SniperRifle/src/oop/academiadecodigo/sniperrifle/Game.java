package oop.academiadecodigo.sniperrifle;

public class Game {

    public GameObject[] objects;

    private SniperRifle sniperRifle = new SniperRifle();

    private int shotsFired;

    public void start(){
        for(int i = 0; i < objects.length; i++){
            if(objects[i] instanceof Shootable){
                while(((Shootable) objects[i]).isShootable() ){
                    sniperRifle.shoot((Shootable) objects[i]);
                    shotsFired++;
                }

            } else {
                System.out.println("You can't shoot a tree");
            }
            
            System.out.println("______________________________________________");
            System.out.println("______________________________________________");
        }
        System.out.println(shotsFired + " shots have been fired");

    }

    public Game(int num){
        objects = new GameObject[num];
        createObjects(num);
    }

    public GameObject[] createObjects(int num){
        for(int i = 0; i< objects.length; i++){
            int randomChance = (int) Math.ceil(Math.random() * 12);
            if(randomChance > 10){
                objects[i] = new Barrel();
            }
            else if(randomChance > 8){
                objects[i] = new Tree();
            }
            else if (randomChance > 4){
                objects[i] = new SoldierEnemy();
            }
            else{
                objects[i] = new ArmouredEnemy();
            }

        }
        return objects;


    }
}
