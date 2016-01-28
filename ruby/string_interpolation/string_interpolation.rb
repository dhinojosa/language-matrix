#Required to load assert, since ruby does not have a standard assert
require_relative '../assert'

# A String can be interpolated with a double quoted string
# Given a couple variable assignments...

name = "Albert Einstein"
age = 76

# It can be interpolated in the string with a hash and bracket
# Anything within the brackets will be replaced with the variable
# values in the context

puts "His name was #{name} and he lived until he was #{age}"

