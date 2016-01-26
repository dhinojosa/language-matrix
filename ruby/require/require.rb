
# Require in ruby loads a file at runtime only once. See load/load.rb for an example of load
# Require uses a bareword with the .rb extension. Require can be used with C files that
# are stored in files ending with .so or .dll

require "classes"

hurley = Employee.new('Elizabeth', 'Hurley')

puts(hurley.first_name)