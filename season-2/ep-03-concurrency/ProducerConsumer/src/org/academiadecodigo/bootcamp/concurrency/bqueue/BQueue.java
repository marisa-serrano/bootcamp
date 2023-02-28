package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */

public class BQueue<T> {

    private int limit;
    private LinkedList<T> queue;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */

    public BQueue(int limit) {
        this.limit = limit;
        queue = new LinkedList<>();
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */

    public synchronized void offer(T data) {

        while (queue.size() == limit) {

            try {
                System.out.println(Thread.currentThread().getName() + ": queue is full....");
                System.out.println("------------------------");

                wait();

            } catch (InterruptedException e) {
                System.out.println("Offer: interrupted exception");
            }
        }

        notifyAll();
        queue.addLast(data);
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */

    public synchronized T poll() {

        while (queue.size() == 0) {

            try {
                System.out.println(Thread.currentThread().getName() + ": queue is empty.");
                System.out.println("------------------------");

                wait();

            } catch (InterruptedException e) {
                System.out.println("Poll: interrupted exception");
            }
        }

        notifyAll();
        return queue.poll();
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */

    public int getSize() {
        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */

    public int getLimit() {
        return limit;
    }
}