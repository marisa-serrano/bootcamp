package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;
import org.academiadecodigo.bootcamp.concurrency.bqueue.Pizza;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
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
                queue.poll();
                elementNum--;
                System.out.println(Thread.currentThread().getName() + " is eating a pizza");
                System.out.println("queue size: " + queue.getSize());
                System.out.println(Thread.currentThread().getName() + " pizzas left: " + elementNum);
                System.out.println("------------------------");
            }
        }
    }
}