start = Time.now

def convert(word)
  value = 0
  word.each_byte {|c| value += c - 64 }
  return value
end

# Build triangle numbers list
triangles = Array.new
n = 1.0
while n < 100
  triangles << (n/2*(n+1)).to_i
  n += 1
end

count = 0
file = File.new("res/words.txt")
file.each_line(",") do |word|
  word.delete! "\"" ","
  if triangles.include?(convert(word))
    count += 1
  end
end
file.close
puts "answer is #{count}"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"
