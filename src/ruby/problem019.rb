require 'date'

start = Time.now

# first sunday of the century
d = Date.new(1901, 1, 6)

count = 0
while (d.year < 2001)
  if d.mday == 1
    count += 1
  end
  d += 7  # go to next sunday
end

puts "answer is #{count}"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"