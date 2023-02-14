package org.academiadecodigo.wizards;

import com.sun.xml.internal.ws.wsdl.writer.document.Import;

import java.util.PriorityQueue;

public class ToDo {

    private PriorityQueue<Item> queue;

    public ToDo() {
        queue = new PriorityQueue<>();
    }

    public boolean add(Importance importance, int priority, String string) {
        return queue.add(new Item(importance, priority, string));
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Item remove() {
        return queue.remove();
    }

    public enum Importance {
        HIGH,
        MEDIUM,
        LOW
    }
}
