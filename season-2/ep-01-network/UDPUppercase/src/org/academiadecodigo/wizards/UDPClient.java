package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    private String message;
    private String host;
    private DatagramSocket socket;
    private int port = 9090;

    public static void main(String[] args) {
        new UDPClient();
    }

    public UDPClient() {
        try {
            init();
            getUserInput();

            while (!message.equals("quit")) {
                send();
                receive();
                getUserInput();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        socket.close();
    }

    private void getUserInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Write message: ");
        message = reader.nextLine();
    }

    private void send() throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);
        socket.send(sendPacket);
    }

    private void receive() throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivePacket);
        message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Message received: " + message);
    }

    private void init() throws SocketException, UnknownHostException {
        host = InetAddress.getLocalHost().getHostAddress();
        socket = new DatagramSocket(port);
    }
}