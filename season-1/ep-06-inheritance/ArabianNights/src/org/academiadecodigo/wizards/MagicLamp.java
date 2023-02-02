package org.academiadecodigo.wizards;

public class MagicLamp {
    private int maxGenies;
    private int nrOfRubs;

    public MagicLamp(int maxGenies){
        this.maxGenies = maxGenies;
    }

    public Genie rub(){
        if (nrOfRubs == maxGenies){
            return new Demon();

        } else if (nrOfRubs % 2 != 0){
            nrOfRubs++;
            return new GrumpyGenie();

        } else {
            nrOfRubs++;
            return new FriendlyGenie();
        }
    }

    public void recharge(Genie[] genies){
        if (genies[genies.length-1] instanceof Demon){
            if (((Demon)genies[genies.length-1]).recycle()) {
                nrOfRubs = 0;
                System.out.println("The magic lamp was recharged");
            }
        }
    }

    public int getMaxGenies(){
        return maxGenies;
    }
}
