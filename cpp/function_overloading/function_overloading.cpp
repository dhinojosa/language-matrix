
// used for assertions
#include <assert.h>

//function headers
int add(int a, int b);
int add(int a, int b, int c);

//overload function, same name, different types
int add(int a, int b) {
   return a + b;
}

//overload function, same name, different types
int add(int a, int b, int c) {
   return a + b + c;
}

int main() {
   assert(add(1,2) == 3);
   assert(add(1,2,3) == 6);
}
