package org.academiadecodigo.wizards;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueWord implements Iterable<String> {

    private String[] words;
    private Set<String> uniqueWords;

    public UniqueWord(String string) {
        words = string.split(" ");
        uniqueWords = new HashSet<>();
        buildHashSet();
    }

    private void buildHashSet() {
        for (String word : words) {
            uniqueWords.add(word);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return uniqueWords.iterator();
    }
}




