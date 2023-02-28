package org.academiadecodigo.wizards;

import java.io.*;
import java.net.ServerSocket;

public class WebServer {
    private int port = 8080;
    private ServerSocket serverSocket;


    public static void main(String[] args) {
        WebServer server = new WebServer();

        try {
            server.init();
           while(!server.serverSocket.isClosed()) {
               server.getRequest();
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void getRequest() throws IOException {
        Thread request = new Thread(new RequestThread(serverSocket.accept()));
        request.start();
    }
}