package com.xyzcorp;

import java.io.*;
import java.net.*;

public class StandardExceptions {
   public static void main(String[] args) {
      URL url = null;
      InputStreamReader reader = null;
      BufferedReader bufferedReader = null;

      try {
         url = new URL("https://finance.google.com/finance/historical?output=csv&q=GOOG");
         reader = new InputStreamReader(url.openStream());
         bufferedReader = new BufferedReader(reader);
         String line = null;
         while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try {
            if (bufferedReader != null) bufferedReader.close();
            if (reader != null) reader.close();
         } catch (IOException ioe) {
            ioe.printStackTrace();
         }
      }
   }
}
