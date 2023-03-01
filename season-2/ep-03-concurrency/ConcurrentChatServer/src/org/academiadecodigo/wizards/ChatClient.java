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
        ChatClient client = new ChatClient();

        try {
            client.init();
            client.receive();

            while (!client.socket.isClosed()) {
                client.getInput();
                client.send();
                client.receive();
                client.print();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void init() throws IOException {
        scanner = new Scanner(System.in);
        host = InetAddress.getLoopbackAddress();
        socket = new Socket(host, PORT);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }

    private void getInput() {
        message = scanner.nextLine();
        System.out.println("client: " + message);
    }

    private void send() throws IOException {
        System.out.println("client sent: " + message);
        out.write(message);
    }

    private void receive() throws IOException {
        message = "";
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        out.print(message);
        System.out.println("client received: " + message);
    }

    private void print() {
        out.println(message);
    }
}