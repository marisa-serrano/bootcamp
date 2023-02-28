package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;
import org.academiadecodigo.bootcamp.concurrency.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        while (elementNum > 0) {

            try {
                Thread.sleep((int) (Math.random() * 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (queue) {
                queue.offer(new Pizza());
                elementNum--;
                System.out.println(Thread.currentThread().getName() + " is making a pizza");
                System.out.println("queue size: " + queue.getSize());
                System.out.println(Thread.currentThread().getName() + " pizzas left: " + elementNum);
                System.out.println("------------------------");
            }
        }
    }
}