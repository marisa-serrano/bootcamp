package org.academiadecodigo.wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket server;

    private static String message;

    private static int port = 8081;

    private static Socket clientSocket;

    private static PrintWriter out;

    private static BufferedReader in;

    public static void main(String[] args) {

        try {
            init();
            receive();
            send();
            server.close();
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  static void init() throws IOException {
        server = new ServerSocket(port);
        clientSocket = server.accept();
    }

    private static void receive() throws IOException {
        System.out.println("recieve!!!!");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        message = in.readLine();
    }

    private static void send() throws IOException {
        System.out.println("woah");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(message);
    }
}

