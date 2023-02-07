package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;


public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();
            fixCrash();
            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        Position crashPos;
        for (Car car : cars){
            if (!car.isCrashed()) {
                car.move();
                crashPos = lookForCrashes();
                CarFactory.getAmbulance(crashPos.getRow(), crashPos.getCol());
            }
        }
    }


    private Position lookForCrashes() {
        Position crashPos = cars[0].getPos();
        for (Car car1 : cars) {
            for (Car car2 : cars) {
                if (car1.getPos().equals(car2.getPos()) && !car1.equals(car2)) {
                    car1.crash();
                    car2.crash();
                    crashPos = car1.getPos();
                }
            }
        }
        return crashPos;
    }

    private void fixCrash(Position pos){
        for (Car car : cars) {
            if (car.getPos().equals(pos) ){
                car.uncrash();
            }
        }
    }
}
