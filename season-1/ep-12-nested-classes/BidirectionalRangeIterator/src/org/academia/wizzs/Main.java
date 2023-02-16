package org.academia.wizzs;

public class Main {
    public static void main(String[] args) {

        Range range = new Range(-5,5);

        System.out.println("Reversed order:");
        range.setReversed(true);
        for(Integer i : range) {
            System.out.println(i);
        }

        System.out.println("-----------------------");

        System.out.println("Natural order:");
        range.setReversed(false);
        for(Integer i : range) {
            System.out.println(i);
        }
    }
}