package com.evolutionnext.exceptions;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionsTest {
    @Test
    void testStandardException() {
        URL url = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            url = new URL("https://finance.google" +
                ".com/finance/historical?output=csv&q=GOOG");
            reader = new InputStreamReader(url.openStream());
            bufferedReader = new BufferedReader(reader);
            String line;
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

    @Test
    void testTryWithResources() {
        URL url = null;
        try {
            url = new URL("https://finance.google" +
                ".com/finance/historical?output=csv&q=GOOG");
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
        try (InputStreamReader reader = new InputStreamReader(url.openStream());
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
