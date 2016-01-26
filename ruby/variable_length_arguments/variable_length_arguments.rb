# Can be declared to load assert, since ruby does not have a standard assert
# $LOAD_PATH.unshift("#{File.dirname(__FILE__)}/..")
# or you can run ruby -I.. variable_length_arguments.rb

require 'assert'

# Variable length argument lists in ruby
# More than one item can be added to the method
# in ruby. 

def add_ingredients(*ing)
   ing.join(', ')
end

assert(add_ingredients("Milk", :Sugar, "Eggs", 14),
                       "Milk, Sugar, Eggs, 14")
