package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.*;


public class ServerUDP {

    private String message;
    private InetAddress host;
    private int port = 8080;
    private DatagramSocket socket;

    public static void main(String[] args) {
        ServerUDP server = new ServerUDP();

        try {
            server.getRequest();

            while (server.socket.isBound()) {
                server.receive();
                server.send();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        server.socket.close();
    }

    private void getRequest() throws SocketException, UnknownHostException {
        socket = new DatagramSocket(port);
    }

    private void receive() throws IOException {
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        host = receivePacket.getAddress();
        port = receivePacket.getPort();

        message = new String(receivePacket.getData());
        System.out.println("Server received this string: " + message);
        message = message.toUpperCase();
        System.out.println(message);
    }

    private void send() throws IOException {
        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, host, port);
        socket.send(sendPacket);
    }
}