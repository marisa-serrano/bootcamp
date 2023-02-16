package org.academiadecodigo.wizard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordReader implements Iterable<String> {

    private FileReader fileReader;
    private BufferedReader bReader;
    private List<String> words = new ArrayList<>();
    String line;
    String[] str;

    public WordReader(String file) throws IOException {
        read(file);
    }

    public void read(String file) throws IOException {

        fileReader = new FileReader(file);
        bReader = new BufferedReader(fileReader);

        while ((line = bReader.readLine()) != null) {
            str = line.split(" ");
            words.addAll(Arrays.asList(str));
        }
        bReader.close();
    }

    public Iterator<String> iterator() {
        return words.iterator();
    }
}