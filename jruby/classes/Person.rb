class Person
    def initialize(first_name, last_name)
        @first_name = first_name
        @last_name = last_name
    end

    def full_name
       "#{first_name} #{last_name}"
    end
end

louis = Person.new('Louis', 'Armstrong')
puts louis.full_name

