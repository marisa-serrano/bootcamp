package org.academiadecodigo.wizards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private Socket socket;
    private InetAddress host;
    private final int PORT = 8082;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;
    private String message;

    public static void main(String[] args) {
        new ChatClient();
    }

    public ChatClient() {

        try {
            init();
            //getCommands();
            cycle();
            send();

            while (!socket.isClosed()) {
                cycle();
            }

            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void init() throws IOException {
        scanner = new Scanner(System.in);
        host = InetAddress.getLoopbackAddress();
        socket = new Socket(host, PORT);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void getInput() {
        message = scanner.nextLine();
    }

    private void send() throws IOException {
        out.println(message);
    }

    private void receive() throws IOException {
        System.out.println(in.readLine());
    }

    private void getCommands() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        getInput();
        send();
    }

    private void cycle() throws IOException {
        receive();
        getInput();
        send();
    }
}