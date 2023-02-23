package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    private static String message;
    private static String host;
    private static DatagramSocket socket;
    private static int port = 9090;

    public static void main(String[] args) {
        try {
            getUserInput();
            init();
            send();
            receive();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
        socket.close();
    }

    private static void getUserInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Write message: ");
        message = reader.nextLine();
    }

    private static void send() throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);
        socket.send(sendPacket);

    }

    private static void receive() throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivePacket);
        message = new String(receivePacket.getData());
        System.out.println("Message received : " + message);
    }

    private static void init() throws SocketException, UnknownHostException {
        host = InetAddress.getLocalHost().getHostAddress();
        socket = new DatagramSocket(port);
    }
}