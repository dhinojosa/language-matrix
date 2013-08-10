#include <iostream>
using namespace std;

int main() {
  short a = 2;
  int b = a; //Automatic conversion
  a = b;
  int c = 500000;
  short d = c; //This is allowed
  cout << "d: " << d;
}
