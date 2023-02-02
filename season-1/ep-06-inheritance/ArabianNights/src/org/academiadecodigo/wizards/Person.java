package org.academiadecodigo.wizards;

public class Person {
    private Genie[] genies;
    private MagicLamp lamp;

    public Person(MagicLamp lamp){
        this.lamp = lamp;
        genies = new Genie[lamp.getMaxGenies()];
        for (Genie genie : genies){
            genie = lamp.rub();
        }
    }
/*
    public void rubLamp(){
        for (Genie genie : genies){
            genie = lamp.rub();
        }
    }*/

    public void askWishes(){
        for (int i = 0; i < genies.length; i++){
            genies[i].grantWish();
        }
    }
}
