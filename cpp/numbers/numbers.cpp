#include <iostream>
#include <typeinfo>
#include <stdio.h>
using namespace std;

int main(void) {
   //Signed Integer, size depends on the computer system!
   //Typically one machine size for a word
   int a; //declaration only
   int b,c,d; //multiple declarations
   
   int e = 0; //declaration and assignment
   int f, g = 30; //valid
   int h = 301, i = 30; //valid

   /* sizeof of returns the size of the data type */
   printf("The size of an int is %lu bytes or %lu bits.\n", 
           sizeof(h), sizeof(h) * 8);

   unsigned int j = 3001; //All numbers are positive, wider range;
   unsigned int k = -30193; //Produces a positive number

   short m = 301;
   unsigned short n = 221;

   long o = 3012933; //4 bytes 
   unsigned long p = 4991292; //4 bytes positive wider range

   long long q = 30102333123; // 8 bytes
   unsigned long long r = 39192939333; //8 bytes positive even wider range

   float s = 3012.03091; // 4 bytes floating point
   double t = 3019.40129; // 8 bytes floating point
   long double u = 3010.40491293; //Vendor specific to support a 
                                  //larger range, 16 bits on 64 bit Linux
   cout << sizeof(u) << endl;

   return 0; //Returning 0 means everything is OK.
}
