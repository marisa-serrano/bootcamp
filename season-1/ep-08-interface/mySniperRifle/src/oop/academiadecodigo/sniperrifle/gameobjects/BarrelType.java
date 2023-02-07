package oop.academiadecodigo.sniperrifle.gameobjects;

public enum BarrelType {
    PLASTIC(50, "Plastic barrel"),
    WOOD(100, "Wood barrel"),
    METAL(150, "Metal barrel");

    private int maxDamage;
    private String description;

    BarrelType(int maxDamage, String description){
        this.maxDamage = maxDamage;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public int getMaxDamage(){
        return maxDamage;
    }
}
