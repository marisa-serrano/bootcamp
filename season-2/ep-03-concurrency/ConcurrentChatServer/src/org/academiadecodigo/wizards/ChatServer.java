package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private ServerSocket socket;
    private final int PORT = 8082;
    private ExecutorService fixedPool;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
        try {
            init();

            while (!socket.isClosed()) {
                getConnection();
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