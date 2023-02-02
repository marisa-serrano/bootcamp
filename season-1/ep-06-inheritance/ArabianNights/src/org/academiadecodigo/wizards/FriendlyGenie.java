package org.academiadecodigo.wizards;

public class FriendlyGenie extends Genie {

    public FriendlyGenie(){
        super(3);
    }

    public void grantWish(){
        if (this.getWishesGranted() < this.getMaxWishes()){
            super.grantWish();
            System.out.println("Your wish is my command <3");

        } else {
            System.out.println("Sorry, I can't grant anymore wishes");
        }
    }
}
