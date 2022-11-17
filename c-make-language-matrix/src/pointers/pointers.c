#include <stdio.h>
#include <assert.h>

void swap_regular(int a, int b); 

void swap_by_pointer(int * a, int * b);

int main(void)
{
    int x = 10;
    int y = 12;
    swap_regular(x, y);
    assert(x == 10);
    assert(y == 12);
    swap_by_pointer(&x, &y);
    assert(x == 12);
    assert(y == 10);
    return 0;
}

void swap_regular(int a, int b) 
{
    int temp = a;
    a = b;
    b = temp;
}

void swap_by_pointer(int * a, int * b)
{
    int temp = *a;
    *a = *b; //*a is what is contained in a, *b is what is contained in b
    *b = temp;
}
