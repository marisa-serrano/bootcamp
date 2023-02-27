package org.academiadecodigo.wizards;

public class MyThread implements Runnable{


    @Override
    public void run() {
        System.out.println("This is the thread: " + Thread.currentThread().getName());
    }
}
