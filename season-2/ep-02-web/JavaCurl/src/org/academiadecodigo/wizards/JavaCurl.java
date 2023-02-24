package org.academiadecodigo.wizards;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JavaCurl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert url:");
        String urlString = scanner.nextLine();
        URL url;

        try {
            url = new URL(urlString);
            InputStream in = new BufferedInputStream(url.openStream());
            InputStreamReader reader = new InputStreamReader(in);
            int bytesRead;

            while ((bytesRead = reader.read()) != -1) {
                System.out.print((char) bytesRead);
            }

            in.close();

        } catch (MalformedURLException e) {
            System.out.println("bad url: " + urlString);

        } catch (IOException e) {
            System.out.println("bad stream");
        }
    }
}