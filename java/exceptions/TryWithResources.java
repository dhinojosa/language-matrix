package com.xyzcorp;

import java.io.*;
import java.net.*;

public class TryWithResources {
   public static void main(String[] args) {
      URL url = null;
      try {
         url = new URL("https://finance.google.com/finance/historical?output=csv&q=GOOG");
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      }
      try (InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(reader)) {
         String line = null;
         while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
   }
}
