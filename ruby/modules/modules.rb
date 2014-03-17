# Modules provide a namespace for any constructs within.
module Alpha
   module Beta
      class Location
	 attr_reader :city, :state, :zip

	 def initialize(city, state, zip)
	    @city = city
	    @state = state
	    @zip = zip
	 end
      end
   end
end

# To refer to a module devide each module name with a `::`
loc = Alpha::Beta::Location.new('Omaha', 'Nebraska', '68007')
puts loc.city == 'Omaha'
puts loc.state == 'Nebraska'
puts loc.zip == '68007'
