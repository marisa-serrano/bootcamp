package org.academiadecodigo.wizards;

import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {
    private int port = 8080;
    private ServerSocket serverSocket;
    private ExecutorService fixedPool;


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
        fixedPool = Executors.newFixedThreadPool(5);
    }

    private void getRequest() throws IOException {
        fixedPool.submit(new RequestThread(serverSocket.accept()));
    }
}