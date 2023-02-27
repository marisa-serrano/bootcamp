package org.academiadecodigo.wizards;

public class ThreadLauncher {

    public static void main(String[] args) {

        // create a task (runnable)
        MyThread myThread = new MyThread();
        // execute (run) the task
        myThread.run();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThread());
            thread.setName("T" + i);
            thread.start();
        }

        // create a thread with a task to execute (myThread)
        Thread thread = new Thread(myThread);
        // start() calls myThread.run() -> executes the task on another thread
        thread.start();

        // myThread (task) is being executed on two different threads (lines 10 and 21)
    }
}
