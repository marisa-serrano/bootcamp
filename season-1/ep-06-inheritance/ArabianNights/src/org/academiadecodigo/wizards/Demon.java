package org.academiadecodigo.wizards;

public class Demon extends Genie{
    private boolean recycled;

    public Demon(){
        super(6);
    }

    public void grantWish(){
        super.grantWish();
        System.out.println("Your wish is my command muahaha");
    }

    public boolean recycle(){
        if (recycled){
            System.out.println("This demon has already been recycled");

        } else {
            recycled = true;
        }
        return recycled;
    }
}
