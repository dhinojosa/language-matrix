package com.evolutionnext.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketsRaw {
    public static void main(String[] args) throws IOException {
        String host = args[0];
        String uri  = args[1];

        System.out.println("Retrieving content from " + host + uri);
        try (Socket socket = new Socket(InetAddress.getByName(host), 80);
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream()) {

            System.out.println(host + " connected?: " + socket.isConnected());

            //Make Raw HTTP Request
            os.write(("GET " + uri + " HTTP/1.1\r\n").getBytes());
            os.write(("Host:" + host + "\r\n").getBytes());
            os.write(("Cache-Control: no-cache\r\n").getBytes());
            os.write("\r\n".getBytes());
            os.flush();

            System.out.println("Sent info");

            int item = -1;
            while ((item = is.read()) != -1) {
                System.out.print((char) item);
            }
        }
    }
}
