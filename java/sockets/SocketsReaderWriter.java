package com.evolutionnext.languagematrix.java;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class SocketsReaderWriter {
  public static void main(String[] args) throws IOException {
     String host = args[0];
     String uri  = args[1];

     System.out.println("Retrieving content from " + host);
     try (Socket socket = new Socket(InetAddress.getByName(host), 80);
          InputStream is = socket.getInputStream();
          OutputStream os = socket.getOutputStream();
          InputStreamReader reader = new InputStreamReader(is);
          OutputStreamWriter writer = new OutputStreamWriter(os);
          BufferedReader bufferedReader = new BufferedReader(reader);
          BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

        System.out.println(host + " connected?: " + socket.isConnected());

        //Make Raw HTTP Request
        bufferedWriter.write("GET " + uri + " HTTP/1.1");
        bufferedWriter.newLine();
        bufferedWriter.write("Host: " + host);
        bufferedWriter.newLine();
        bufferedWriter.write("Cache-Control: no-cache");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("Sent info");

        String line;
        while ((line = bufferedReader.readLine()) != null) {
           System.out.println(line);
        }
     }
  }
}
