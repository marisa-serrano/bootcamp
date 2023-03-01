package org.academiadecodigo.wizards;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ServerWorker implements Runnable {

    private Socket clientSocket;
    private static LinkedList<ServerWorker> workers = new LinkedList<>();
    private BufferedReader in;
    private PrintWriter out;
    private String message;
    private String username;

    public ServerWorker(Socket socket) {
        this.clientSocket = socket;
        workers.add(this);
    }

    @Override
    public void run() {
        try {
            init();

            String line;

            while ((line = in.readLine()) != null) {
                message = line;

                if(!checkCommands()) {
                    sendToAll();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        username = Thread.currentThread().getName();
    }

    private void sendToAll() {
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).send(username, message);
        }
    }

    private void send(String name, String message) {
        out.println(name + ": " + message);
    }

    private boolean checkCommands() throws IOException {

        switch (message) {

            case "exit":
                exit();
                return true;

            case "list":
                showList();
                return true;

            case "username":
                setUsername();
                return true;

            default:
                return false;
        }
    }

    private void exit() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        workers.remove(this);
    }

    private void showList() {
        out.println("SERVER CONNECTED TO:");
        for (int i = 0; i < workers.size(); i++) {
            out.println(workers.get(i).getName());
        }
    }

    private void setUsername() throws IOException {
        out.println("New username:");
        username = in.readLine();
    }

    private String getName() {
        return username;
    }
}