package org.academiadecodigo.wizards;

public class GrumpyGenie extends Genie{

    public GrumpyGenie(){
        super(5);
    }

    public void grantWish(){
        if (this.getWishesGranted() < 1){
            super.grantWish();
            System.out.println("Your stupid wish was granted");

        } else {
            System.out.println("Leave me alone");
        }
    }
}
