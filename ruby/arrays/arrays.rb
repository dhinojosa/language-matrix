a = [1, 2, 3, 4, 5]

b = a.collect do |i|
  i + 2
end

c = a.collect {|i| i + 10}

puts "a: #{a}"
puts "b: #{b}"
puts "c: #{c}"

d = a[1]
puts "d:  #{d}"

e = a.select{|i| i % 2 == 0}

puts "e:#{e}"

a.each{|i| puts i}

a.each_index{|i| puts i}

a.each_with_index{|o,i| puts "Object: #{o}; Index: #{i}"}

f = a.delete_if do |i|
  i > 3
end

puts "a:#{a}"
puts "f:#{f}"

