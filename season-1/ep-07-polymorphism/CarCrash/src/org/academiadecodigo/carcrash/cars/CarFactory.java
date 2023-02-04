package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static Car getNewCar() {
        int i = (int) (Math.random() * 3);

        switch (i) {
            case 0:
                return new Ferrari();
            case 1:
                return new Porsche();
            default:
                return new Citroen();
        }

    }

    public static Car getAmbulance(int row, int col){
        return new Ambulance(row, col);
    }
}
