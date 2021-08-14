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

#include <iostream>
#include <assert.h>

int addByValue(int a, int b);
int addByReference(int &a, int b);
int& returnByReference(int a, int b);

//This method adds by value. A copy is always provided, 
//and therefore the original is never changed from 
//within the scope
int addByValue(int a, int b) {
  return (++a) + b;
}

//This method adds by reference. Adding by reference.
//will change the value from with the function.
int addByReference(int &a, int b) {
  return (++a) + b;
}

int result = 0;

int returnByValue(int a, int b) {
   result = a + b;
   return result;
}

//We should be able to return a reference from a function
int& returnByReference(int a, int b) {
    result = a + b;
    return result;
}

int main() {
  int x = 10;
  int y = 20;

  assert(addByValue(x, y) == 31);
  assert(x == 10);
  assert(y == 20);
  assert(addByReference(x, y) == 31);
  assert(x == 11);
  assert(y == 20);

  //return by value
  int value = returnByValue(3, 10);
  value++;
  assert(result == 13);

  result = 0; //reset the result

  //return by reference
  int reference = returnByReference(3, 10);
  reference++;
  assert(reference == 14);
}
