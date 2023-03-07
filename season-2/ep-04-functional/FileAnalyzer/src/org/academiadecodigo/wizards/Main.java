package org.academiadecodigo.wizards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String file1Path = "resources/file1.txt";
        String file2Path = "resources/file2.txt";


        System.out.println(FileAnalyzer.countWords(file1Path));
        System.out.println(FileAnalyzer.countWords(file2Path));

        System.out.println(FileAnalyzer.firstWord(file1Path, 5));
        System.out.println(FileAnalyzer.firstWord(file2Path, 6));

        System.out.println(FileAnalyzer.longestWords(file1Path, 5));
        System.out.println(FileAnalyzer.longestWords(file2Path, 6));

    }

}
