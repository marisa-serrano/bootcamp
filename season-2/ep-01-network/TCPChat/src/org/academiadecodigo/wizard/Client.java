package org.academiadecodigo.wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static InetAddress host;
    private static String message = "message";
    private static int port = 8081;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        try {
            init();
            getInput();

            while (!message.equals("quit")) {
                send();
                receive();
                printer();
                getInput();
            }

            clientSocket.close();
            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your message:");
        message = scan.nextLine();
        message += "\n";
    }

    private static void init() throws IOException {
        host = InetAddress.getLoopbackAddress();
        clientSocket = new Socket(host, port);
    }

    private static void send() throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(message);
    }

    private static void receive() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private static void printer() throws IOException {
        System.out.println(in.readLine());
    }
}