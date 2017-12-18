/*
 * Copyright (c) 2017 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 * Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.util.ArrayList;
import java.util.List;

public class CovarianceExtends {

   public static class Human{}
   public static class NorthAmerican extends Human{}
   public static class American extends NorthAmerican {}
   public static class NewMexican extends American {}
   public static class Coloradan extends American {}
   public static class SantaFean extends American {}
   public static class Albuquerquean extends American {}


   /* Class that describes covariance
    *  This uses the extends keyword
    *  Variance in Java is use-site variance
    */
   public static void main(String[] args) {

      //An example of covariance with extends
      List<? extends American> americans = new ArrayList<NewMexican>();

      Object object = americans.get(0);
      Human human = americans.get(0);
      NorthAmerican northAmerican = americans.get(0);
      American american = americans.get(0);
      //NewMexican newMexican = americans.get(0); Will not compile
      //SantaFean santaFean = americans.get(0); Will not compile

      americans.add(null);
   }
}
