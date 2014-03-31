# By default any variable that is list under the class 
# is a class variable that belongs solely to the class
# not to any instance

class Counter:
   """A simple counter class"""
   count = 0

Counter.count = 12
assert Counter.count == 12
Counter.count += 1
assert Counter.count == 13

# There is a specialized method called __doc__ that returns the 
# documentation of the class

assert Counter.__doc__ == "A simple counter class"
