package org.academiadecodigo.carcrash.cars;

public class Ferrari extends Car{

    public Ferrari(){
        super();
    }

    public String toString(){
        if (isCrashed()) {
            return "C";
        }
        return "F";
    }
}
