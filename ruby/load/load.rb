
# Load in ruby loads a file at runtime every time it is used, it also not cached, as opposed
# to require. This is not commonly used except on Ruby on Rails that does so to avoid caching

load "classes.rb" # Note the use of rb which is not required when using require

hurley = Employee.new('Elizabeth', 'Hurley')

puts(hurley.first_name)