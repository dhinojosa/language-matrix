package com.evolutionnext.intersectiontypes;

import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class JavaIntersectionTypes {
   private static <T extends Appendable & Flushable & Closeable> 
      void foo(T t) throws IOException {
         t.append('c');
         t.append('d');
         t.flush();
         t.close();
      }

   public static void main(String[] args) throws IOException {
      CharArrayWriter writer = new CharArrayWriter(40);
      foo(writer);
      System.out.println(writer.toCharArray());
   }
}
