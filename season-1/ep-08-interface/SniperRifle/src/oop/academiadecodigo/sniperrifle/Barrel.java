package oop.academiadecodigo.sniperrifle;

public class Barrel extends GameObject implements Shootable{

    private boolean isDestroyed;

    public void hit(int damage){
        isDestroyed = true;
        System.out.println("Barrel was destroyed");
    }
    public boolean isShootable(){
        return !isDestroyed;
    }
}
