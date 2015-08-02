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
