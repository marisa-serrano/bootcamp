package org.academiadecodigo.wizards;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {

    // Timer: allows us to schedule tasks for the future
    Timer timer;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of times to ring:");
        int rings = Integer.parseInt(scanner.next());

        System.out.println("Ring interval in seconds:");
        int interval = Integer.parseInt(scanner.next());

        Alarm alarm = new Alarm();
        alarm.start(rings, interval);

        Alarm alarm1 = new Alarm();
        alarm1.start(rings, interval);

        Alarm alarm2 = new Alarm();
        alarm2.start(rings, interval);

        // see what thread is running (shows up before start() -> lost control of the order)
        System.out.println(Thread.currentThread().getName());
    }

    private void start(int rings, int interval) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(rings), interval * 1000, interval * 1000);
    }


    // TimerTask: task scheduled (by the timer) to be executed in the future
    private class Ring extends TimerTask {
        int rings;

        public Ring(int rings) {
            this.rings = rings;
        }

        @Override
        public void run() {
            System.out.println("Alarm is ringing...");
            rings--;

            // see what thread is running
            System.out.println(Thread.currentThread().getName());

            if (rings == 0) {
                System.out.println("Alarm stopped, thank God!");
                stop();
            }
        }

        private void stop() {
            timer.cancel();
        }
    }
}