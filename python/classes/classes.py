
"""A simple class declaration with nothing in it must use 'pass'
   The 'pass' statement is like {} in C++ or Java"""
class Simple:
   pass

"""Instantiating the class"""
g = Simple()

"""Placing a property that doesn't exist and using it"""

g.some_variable = 17

"""Using that property to continually mutate the class"""

while g.some_variable > 15:
   g.some_variable-=1

print (g.some_variable)

"""You can remove the data attribute with del on the object"""
del g.some_variable

"""You can create a class with some simple class attribute, the variable belong to a class, """
class Counter:
   """A simple counter class"""
   count = 19

print (Counter.count)

"""You can retrieve the doc of the class by calling __doc__"""
print(Counter.__doc__)

"""Variable state that"""
