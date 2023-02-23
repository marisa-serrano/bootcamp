package org.academiadecodigo.wizards;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class DNSResolver {

    public static void main(String[] args) {
        DNSResolver dnsResolver = new DNSResolver();
        dnsResolver.getHost();
        dnsResolver.testReachability();
    }

    private String hostname;

    public void getHost() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Domain?");
        // receber domínio (ex: google.com)
        hostname = reader.nextLine();
    }

    public void testReachability() {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            // obter ip address
            System.out.println("Testing reachability for " + address.getHostAddress());
            // ping
            System.out.println(address.isReachable(10000) ? "OK" : "FAIL");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}