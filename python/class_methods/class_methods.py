# By default any method that is listed under the 
# class that doesn't contain self as an argument
# is a class method that belongs solely to the class
# not to any instance

class Counter:
   """A simple counter class"""
   count = 0

   @classmethod
   def current_count(cls):
      """Return the count value inside of the class"""
      return cls.count

Counter.count = 12
assert Counter.current_count() == 12
Counter.count += 1
assert Counter.current_count() == 13
