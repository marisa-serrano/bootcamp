package org.academiadecodigo.wizards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    byte[] buffer = new byte[1024];
    FileInputStream inputStream;
    FileOutputStream outputStream;

    public static void main(String[] args) {

    }

    public void copy(String sourceFile, String copiedFile) {

        try {
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(copiedFile);
            int num;

            while ((num = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, num);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
           closeStreams();
        }
    }

    public void closeStreams() {

        try {
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
