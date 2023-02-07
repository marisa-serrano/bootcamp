package oop.academiadecodigo.sniperrifle.gameobjects;

public class Barrel extends GameObject implements Shootable {

    private boolean isDestroyed;
    private BarrelType type;
    private int currentDamage;

    public Barrel() {
        int randomType = (int) (Math.random() * BarrelType.values().length);
        type = BarrelType.values()[randomType];
    }

    @Override
    public void hit(int damage){
        if ((currentDamage + damage) < type.getMaxDamage()) {
            currentDamage += damage;
            System.out.println(type.getDescription() + " was hit");
        }

        if ((currentDamage + damage) >= type.getMaxDamage()) {
            isDestroyed = true;
            System.out.println(type.getDescription() + " was destroyed");
        }
    }

    public boolean isShootable(){
        return !isDestroyed;
    }

    public String getMessage(){
        return type.getDescription();
    }
}
