
#include <stdio.h>
int main(void) {
   //Signed Integer, size depends on the computer system!
   //Typically one machine size for a word
   int a; //declaration only
   int b,c,d; //multiple declarations
   
   int e = 0; //declaration and assignment
   int f, g = 30; //valid
   int h = 301, i = 30; //valid

   /* sizeof of returns the size of the data type */
   printf("The size of an int is %d bytes or %d bits.\n", 
           sizeof(h), sizeof(h) * 8);
   return 0; //Returning 0 means everything is OK.
}
