package oop.academiadecodigo.sniperrifle;

import oop.academiadecodigo.sniperrifle.gameobjects.*;

public class Game {

    public GameObject[] objects;

    private SniperRifle sniperRifle = new SniperRifle();

    private int shotsFired;

    public void start(){
        for (GameObject object : objects){
            if(object instanceof Shootable){
                while(((Shootable) object).isShootable()){
                    sniperRifle.shoot((Shootable) object);
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
        for (GameObject object : objects) {
            object = ObjectFactory.createNewObject();
            System.out.println(object.getMessage());
        }
        return objects;


    }
}
