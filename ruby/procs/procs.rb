#Starting off with a regular block
def sample_block
  puts "Hello"
  yield(3, 4)
  puts "Done"
end

sample_block do |i, j|
   puts "#{i + j}"
end

#To assign it we have to create a proc. Hmm
op = Proc.new{|i, j| puts "#{i * j}"}

def sample_block_2(&op)
  puts "Hello"
  op.call(3, 4)
  puts "Done"
end

sample_block_2(&op)

sample_block_2 {|i, j| puts "#{i * j}"}

lambda = lambda{|i, j| puts "#{i ** j}"}

sample_block_2(&lambda)