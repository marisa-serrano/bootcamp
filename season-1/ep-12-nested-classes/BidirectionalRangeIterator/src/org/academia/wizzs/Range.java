package org.academia.wizzs;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private int min;
    private int max;
    private boolean reversed;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setReversed(boolean bool) {
        reversed = bool;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (reversed) {
            return new Iterator<Integer>() {
                private int current = max;

                @Override
                public boolean hasNext() {
                    return current >= min;
                }

                @Override
                public Integer next() {
                    return current--;
                }
            };
        }
        return new Iterator<Integer>() {
            private int current = min;

            @Override
            public boolean hasNext() {
                return current <= max;
            }

            @Override
            public Integer next() {
                return current++;
            }
        };
    }
}