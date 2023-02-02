package org.academiadecodigo.wizards;

public class Genie {
    private int maxWishes;
    private int wishesGranted;

    public Genie(int maxWishes){
        this.maxWishes = maxWishes;
    }

    public void grantWish(){
        wishesGranted++;
    }

    public int getMaxWishes(){
        return maxWishes;
    }

    public int getWishesGranted(){
        return wishesGranted;
    }
}
