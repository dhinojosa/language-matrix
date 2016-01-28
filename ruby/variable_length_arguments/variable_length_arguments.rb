
require_relative '../assert'

# Variable length argument lists in ruby
# More than one item can be added to the method
# in ruby. 

def add_ingredients(*ing)
   ing.join(', ')
end

assert(add_ingredients("Milk", :Sugar, "Eggs", 14),
                       "Milk, Sugar, Eggs, 14")
