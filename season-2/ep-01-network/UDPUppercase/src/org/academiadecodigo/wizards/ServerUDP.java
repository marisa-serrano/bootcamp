package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.*;


public class ServerUDP {

    private static String message;
    private static String host = null;
    private static int port = 8080;
    private static byte[] receiveBuffer = new byte[1024];
    private static byte[] sendBuffer;
    private static DatagramSocket socket;

    public static void main(String[] args) {

        try {
            getRequest();
            receive();
            send();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        socket.close();
    }

    private static void getRequest() throws SocketException, UnknownHostException {
        host = InetAddress.getLocalHost().getHostAddress();
        System.out.println(host);
        socket = new DatagramSocket(port);
    }

    private static void receive() throws IOException {
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);
        port = receivePacket.getPort();
        message = new String(receivePacket.getData());
        System.out.println("Server recieved this string -> " + message);
        message = message.toUpperCase();
    }

    private static void send() throws IOException {
        sendBuffer = message.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(host), port);
        socket.send(sendPacket);
    }

}
