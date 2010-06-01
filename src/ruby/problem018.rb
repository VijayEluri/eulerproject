require 'date'

def initArray()
  array = Array.new
  array << %w[75]
  array << %w[95 64]
  array << %w[17 47 82]
  array << %w[18 35 87 10]
  array << %w[20 04 82 47 65]
  array << %w[19 01 23 75 03 34]
  array << %w[88 02 77 73 07 63 67]
  array << %w[99 65 04 28 06 16 70 92]
  array << %w[41 41 26 56 83 40 80 70 33]
  array << %w[41 48 72 33 47 32 37 16 94 29]
  array << %w[53 71 44 65 25 43 91 52 97 51 14]
  array << %w[70 11 33 28 77 73 17 78 39 68 17 57]
  array << %w[91 71 52 38 17 14 91 43 58 50 27 29 48]
  array << %w[63 66 04 68 89 53 67 30 73 16 69 87 40 31]
  array << %w[04 62 98 27 23 09 70 98 73 93 38 53 60 04 23]
  return array
end

def traverse(array, i, j, sum, max)  
  sum += array[i][j].to_i
  if (i + 1 < array.length)
    traverse(array, i + 1, j, sum, max)
    traverse(array, i + 1, j + 1, sum, max)
  else
    max[0] = sum if sum > max[0]
  end
end

start = Time.now
max = [0]
traverse(initArray(), 0, 0, 0, max)
puts "answer is #{max[0]}"
stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"