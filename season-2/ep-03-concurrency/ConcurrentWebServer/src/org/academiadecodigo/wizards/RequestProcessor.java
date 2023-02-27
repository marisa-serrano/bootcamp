package org.academiadecodigo.wizards;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestProcessor implements Runnable {

    private Socket clientSocket;
    private String header;
    private String[] split;
    private String path;
    private String extension;
    private File file;
    private DataOutputStream out;
    private long fileSize;

    private String responseHeader;

  // todo criar header "dinamico" conforme tipo e size.
    // encapsulamento fucked up

    // muitas responsabilidades num método

    // mão há um flow simples de seguir, e por isto, subentenda-se: o flow do programa desde o inicio até ao fim da execucao nao é claro, ya...

    // dividir mais as responsabilidades

    // meter os métodos com responsabilidades mais simples

    // ver quando é que precisamos das variaveis diferentes e tomar atenção a quando atribuimos valor. que foi basicamente o que estragou esta implementacao

    // a string é final e imutável

    private String success = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <" + fileSize + ">\r\n" +
            "\r\n";

    private String notFound = "HTTP/1.0 404 Not Found" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <" + fileSize + ">\r\n" +
            "\r\n";

    private String imageHeader = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: image/" + extension + " \r\n" +
            "Content-Length: " + fileSize + "\r\n" +
            "\r\n";

    public RequestProcessor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            getRequest();
            sendHeader();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getRequest() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        header = in.readLine();
        split = header.split(" ");
        path = (split[1].equals("/")) ? "/index" : split[1];
        extension = (path.split("\\.").length > 1) ? path.split("\\.")[1] : "html";
    }

    private String returnHeader(String x,long y) {

        return   "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: image/" + x + " \r\n" +
                "Content-Length: " + y + "\r\n" +
                "\r\n";

    }

    private void sendHeader() throws IOException {
        out = new DataOutputStream(clientSocket.getOutputStream());
        if (split[0].equals("GET")) {
            showWebSite();
        }
    }

    private void showWebSite() throws IOException {

        System.out.println(path);
        switch (extension) {
            case "jpeg":
            case "jpg":
            case "png":
                file = new File("www" + path);
                responseHeader = imageHeader;
                break;

            default:
                file = new File("www" + path + "." + extension);
                responseHeader = success;
        }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            fileSize = file.length();
            System.out.println(fileSize);

            if(path.equals("/image")){

               out.writeBytes(returnHeader(extension, fileSize));
            }
      //      out.writeBytes(responseHeader);


        } catch (FileNotFoundException e) {
            file = new File("www/404.html");
            reader = new BufferedReader(new FileReader(file));
            fileSize = file.length();
            System.out.println(fileSize);
            out.writeBytes(notFound);

        } finally {
            byte[] buffer = new byte[1024];
            int bytesRead;
            reader = new BufferedReader(new FileReader(file));
            out.write(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            //        while ((bytesRead = reader.read()) != -1) {
            //          out.write(buffer, 0, bytesRead);
            //    }
        }
    }
}