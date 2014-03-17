#A class in Ruby is declared with the keyword `class`

class Employee

   #Constructors are methods called `initialize
   def initialize(first_name, last_name)
      #The @ designate that it will be assigned to member variable
      @first_name = first_name 
      @last_name = last_name
   end

   #Method will return the first name of the employee
   def first_name
      #Last statement in a method will return
      @first_name
   end

   def last_name
      @last_name
   end

   def full_name
      #Using String interpolation to return the full name
      "#{@first_name} #{@last_name}"
   end
end

#Instantiation uses the class name followed by new
barker = Employee.new('Bob', 'Barker')

puts barker.first_name
puts barker.last_name
