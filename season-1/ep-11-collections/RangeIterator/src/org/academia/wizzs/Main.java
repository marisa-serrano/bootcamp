package org.academia.wizzs;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Range range = new Range(-5,5);



        Iterator it = range.iterator();


        it.n

        while(it.hasNext()){

            System.out.println(it.next());
            it.remove();
            //ystem.out.println(it.next());
            //it.remove();
        }

        //it.remove();
    }
}