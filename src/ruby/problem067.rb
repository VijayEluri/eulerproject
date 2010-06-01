require 'date'

def initArray()
  array = Array.new
  file = File.new("res/triangle.txt")
  file.each_line do |line|        
    subarray = Array.new
    line.each(" ") {|n|
      subarray << n
    }
    array << subarray
  end
  file.close
  return array
end

def max(n1, n2)
  if n1 >= n2
    return n1
  else
    return n2
  end
end

def traverse(array)  
  line = array.last
  i = array.length - 1
  while i > 0
    next_line = Array.new
    for j in (0..line.length - 2)
      n = max(line[j].to_i, line[j + 1].to_i)        
      next_line << (n + array[i - 1][j].to_i)
    end
    line = next_line    
    i -= 1
  end
  return line[0].to_i
end

start = Time.now
max = traverse(initArray())
puts "answer is #{max}"
stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"