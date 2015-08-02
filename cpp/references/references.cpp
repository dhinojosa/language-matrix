#include <iostream>
#include <assert.h>

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

int main() {
  int x = 10;
  int y = 20;

  assert(addByValue(x, y) == 31);
  assert(x == 10);
  assert(y == 20);
  assert(addByReference(x, y) == 31);
  assert(x == 11);
  assert(y == 20);
}
