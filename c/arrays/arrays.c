#include <stdio.h>

#define SIZE 20
int main() {
   //Included with initialization
   int int_array[5] = {1,2,3,4,5}; 
   int a = int_array[3];
   printf("a is %d\n", a);

   float float_array[3];
   float_array[1] = 4.0f;

   //Remember sizeof will determine the size of an item in bytes.
   //This is an idiomatic way of determining a size of an array
   //since the size of a data type is dependent on the architecture.
   int size = sizeof(float_array)/sizeof(float_array[0]);
  
   //Using a for loop to iterate the array.
   for (int i = 0; i < size; i++) {
      printf("float_array[%i] = %f\n", i, float_array[i]);
   }

   double double_int_array[SIZE] = {1, 4, 3, 2, 10, 19, 30, 40, 55, 102};
   printf("double_int_array[4] = %f\n", double_int_array[4]);

   //You don't need to particularly declare the size when issuing an array to 
   //a variable.
   int inferred_size_array[] = {3, 4, 10, 19};
   printf("inferred_size_array[2] = %d\n", inferred_size_array[1]);
   printf("size of inferred_size_array is = %ld\n", 
         sizeof(inferred_size_array)/sizeof(inferred_size_array[0]));
   return 0;
}
