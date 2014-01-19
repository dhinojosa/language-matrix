import functools

def mult2(n):
   "Multiply a number by 2"
   return n * 2

assert mult2(4) == 8

assert (list(map(mult2,[1,2,3,4,5]))) == [2,4,6,8,10]

assert (list(map(lambda a: a * 2, [1,2,3,4,5]))) == [2,4,6,8,10]

assert functools.reduce(lambda total, item: total + item, [1,2,3,4,5], 0) == 15

