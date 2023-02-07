package oop.academiadecodigo.sniperrifle.gameobjects;

public class ObjectFactory {

    public static GameObject createNewObject() {
        int randomChance = (int) Math.ceil(Math.random() * 12);
        if(randomChance > 10){
            return new Barrel();
        }
        else if(randomChance > 8){
            return new Tree();
        }
        else if (randomChance > 4){
            return new SoldierEnemy();
        }
        else{
            return new ArmouredEnemy();
        }
    }
}
