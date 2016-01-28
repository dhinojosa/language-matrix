# Discovering a block
def sample_block
   puts "Hello"
   yield #Yields the block
   yield #Yields the block
   puts "Done"
end

#Simple way to create a block
sample_block { puts "World" } 

# Another way to create a block like above
sample_block do
   puts "World 2"
end

def sample_block_with_arguments
   puts "Hello"
   yield("Kirk", "Shatner")
   yield("Spock", "Nimoy")
   puts "Done"
end

# `<<` concats strings
sample_block_with_arguments { |star_trek_character, real_name| 
               puts "The star trek character #{star_trek_character} " <<
                    "is played by #{real_name}."}

