package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private ServerSocket socket;
    private final int PORT = 8081;
    private ExecutorService fixedPool;

    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        try {
            server.init();

            while (!server.socket.isClosed()) {
                server.getConnection();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        socket = new ServerSocket(PORT);
        fixedPool = Executors.newFixedThreadPool(8);
    }

    private void getConnection() throws IOException {
        ServerWorker worker = new ServerWorker(socket.accept());
        fixedPool.submit(worker);
    }
}