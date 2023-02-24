package org.academiadecodigo.wizards;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;

public class WebServer {

    private InetAddress host;
    private int port = 8080;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream out;

    private String path;
    private String request;
    private String[] split;
    private long fileSize;
    private String message1 = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <" + fileSize + ">\r\n" +
            "\r\n";

    private String message2 = "HTTP/1.0 404 Not Found" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <" + fileSize + ">\r\n" +
            "\r\n";


    public static void main(String[] args) {
        WebServer server = new WebServer();

        try {
            server.init();
            server.getRequest();
            server.sendHeader();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
    }

    private void getRequest() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        request = in.readLine();
        split = request.split(" ");
        path = (split[1].equals("/")) ? "/index" : split[1];
        System.out.println(path);
        System.out.println(request);
    }

    private void sendHeader() throws IOException {
        out = new DataOutputStream(clientSocket.getOutputStream());
        if (split[0].equals("GET")) {
           showWebSite();
        }
    }

    private void showWebSite() throws IOException {
        File file = new File("www" + path + ".html");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            fileSize = file.length();
            System.out.println(fileSize);
            out.writeBytes(message1);

        } catch (FileNotFoundException e) {
            file = new File("www/404.html");
            reader = new BufferedReader(new FileReader(file));
            fileSize = file.length();
            System.out.println(fileSize);
            out.writeBytes(message2);

        } finally {
            String line;

            while ((line = reader.readLine()) != null) {
                out.writeBytes(line);
            }
        }
    }
}
