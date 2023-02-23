package org.academiadecodigo.wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String host;

    private static String message;

    private static int port = 8080;

    private static Socket clientSocket;

    private static PrintWriter out;

    private static BufferedReader in;


    public static void main(String[] args) {
        try {
            getInput();
            init();
            send();
            receive();
            printer();
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your message: ");
        message = scan.nextLine();
        message += "\n";
    }

    private static void init() throws IOException {
        host = InetAddress.getLocalHost().getHostName();
        //   System.out.println(host);
        clientSocket = new Socket(InetAddress.getLoopbackAddress(), 8081);
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