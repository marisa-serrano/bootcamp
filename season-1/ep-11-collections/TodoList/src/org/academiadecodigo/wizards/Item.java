package org.academiadecodigo.wizards;

public class Item implements Comparable<Item> {

    private ToDo.Importance importance;
    private int priority;
    private String string;

    public Item(ToDo.Importance importance, int priority, String string) {
        this.importance = importance;
        this.priority = priority;
        this.string = string;
    }

    @Override
    public int compareTo(Item otherItem) {
        if (importance.equals(otherItem.importance)) {
            if (priority - otherItem.priority == 0) {
                return -1;
            } return priority - otherItem.priority;
        }
        return importance.compareTo(otherItem.importance);
    }

    @Override
    public String toString() {
        return string;
    }
}
