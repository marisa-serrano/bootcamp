package org.academiadecodigo.wizards;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestThread implements Runnable {

    private BufferedReader in;
    private DataOutputStream out;
    private String path;
    private String extension;
    private String verb;

    @Override
    public void run() {
        try {
            getInfo();
            if (verb.equals("GET")) {
                File file = getFile();
                sendHeader(file);
                showFile(file);
            }

            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public RequestThread (Socket clientSocket) {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getInfo() throws IOException {
        String[] header = in.readLine().split(" ");
        verb = header[0];
        path = (header[1].equals("/")) ? "/index" : header[1];

        if (path.split("\\.").length > 1) {
            extension = path.split("\\.")[1];
            path = path.split("\\.")[0];

        } else {
            extension = "html";
        }

        System.out.println(path);
        System.out.println(extension);
        System.out.println("www" + path + "." + extension);
    }

    private File getFile() throws IOException {
        File file;

        try {
            file = new File("www" + path + "." + extension);
            BufferedReader reader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            file = new File("www/404.html");
        }

        return file;
    }

    private void sendHeader(File file) throws IOException {
        String message;

        if (file.getName().equals("www/404.html")) {
            message = "HTTP/1.0 404 Not Found" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: <" + file.length() + ">\r\n" +
                    "\r\n";
        } else {

            switch (extension) {
                case "png":
                case "jpg":
                case "jpeg":
                case "ico":
                    message = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: image/" + extension + " \r\n" +
                            "Content-Length: " + file.length() + "\r\n" +
                            "\r\n";
                    break;

                default:
                    message = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: <" + file.length() + ">\r\n" +
                            "\r\n";
            }
        }

        out.writeBytes(message);
    }

    private void showFile(File file) throws IOException {
        out.write(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
    }
}
