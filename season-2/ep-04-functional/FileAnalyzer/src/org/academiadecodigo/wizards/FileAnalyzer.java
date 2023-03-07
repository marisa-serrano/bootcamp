package org.academiadecodigo.wizards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class FileAnalyzer {

    public static long countWords(String filePath) {
        try {

            //Stream<String> elemento ="Uma linha muito grande"
            //  Stream<String[] elemento = [Uma, linha, muito, grande]
            // Stream<String> elemento = "Uma";
            return Files.lines(Paths.get(filePath))
                    .map(str -> str.split(" "))
                    .flatMap(n -> Arrays.stream(n))
                    .count();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<String> firstWord(String filePath, int n) {
        try {

           return Files.lines(Paths.get(filePath))
                    .map(str -> str.split(" "))
                    .flatMap(Stream::of)
                    .filter(word -> word.length() > n)
                    .findFirst();

            //      System.out.println(firstWord);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] longestWords(String filePath, int limit){

        try {
            return (String[]) Files.lines(Paths.get(filePath))
                    .map(str -> str.split(" "))
                    .flatMap(Stream::of)
                    .sorted(Comparator.comparingInt(String::length))
                    .limit(limit)
                    .toArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}