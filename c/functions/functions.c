#include<assert.h>

double power(double val, unsigned pow)
{       double ret_val = 1.0;
  unsigned i;

  for(i = 0; i < pow; i++)
    ret_val *= val;

  return(ret_val);
}

int main() 
{
  assert(power(2.0, 3) == 8.0);
}
