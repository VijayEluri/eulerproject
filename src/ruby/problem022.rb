def getNameValue(name)
  value = 0
  name.each_byte {|c| value += c - 64 }
  return value
end

start = Time.now

# Fill array from file
array = Array.new
file = File.new("res/names.txt")
file.each_line(",") do |names|
  names.delete! "\"" ","
  array << names
end
file.close

# Compute bame value
count = 0
array.sort!
array.each_index {|i|
  count += getNameValue(array[i]) * (i + 1)
}

puts "answer is #{count}"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"