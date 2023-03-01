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
        System.out.println("server worker client socket: " + socket);
        workers.add(this);
    }

    @Override
    public void run() {
        try {
            init();

            while (!clientSocket.isClosed()) {
                receive();

                if (!checkCommands()) {
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
        System.out.println("server in: " + in);
        System.out.println("server out: " + out);

        showCommands();
        setUsername(true);
    }

    private void receive() throws IOException {
        message = in.readLine();
        System.out.println("server received: " + message);
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
                setUsername(false);
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
        out.println("CONNECTED CLIENTS:");
        for (int i = 0; i < workers.size(); i++) {
            out.write(workers.get(i).getName());

            // alternativa :

            // chamar um método do cliente, que recebesse como argumento uma string que seria o output deste método

        }
    }


    private void setUsername(boolean firstTime) throws IOException {
        String prompt = (firstTime) ? "Username:" : "New username:";
        out.println(prompt);
        username = in.readLine();
    }

    private void showCommands() {
        String commands = "----------- COMMANDS ------------\n" +
                          "list: see connected clients\n" +
                          "username: change your username\n" +
                          "exit: close connection\n" +
                          "---------------------------------\n";

        out.print(commands);
    }

    private String getName() {
        return username;
    }
}