package org.academia.wizzs;
import java.util.Iterator;

public class Range implements Iterable<Integer>{

    private int min;
    private int max;




    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator iterator() {
        return new FwdIterator();
    }




    public class FwdIterator implements Iterator<Integer>{

        private int currentElement = min;


        public boolean hasNext(){
            return currentElement <= max;
        }

        public Integer next(){
            return currentElement++;
        }

        public int getCurrentElement() {
            return currentElement;
        }

        @Override
        public void remove(){
           if(hasNext()){
               currentElement++;
           }


        }
    }
}
