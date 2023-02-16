package org.academiadecodigo.wizards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    byte[] buffer = new byte[1024];
    public void copy(String sourceFile, String copiedFile) throws IOException {

        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(copiedFile);
        int num = inputStream.read(buffer);

        while (num != -1) {
            outputStream.write(buffer, 0, num);
            num = inputStream.read(buffer);
        }

        inputStream.close();
        outputStream.close();
    }
}
