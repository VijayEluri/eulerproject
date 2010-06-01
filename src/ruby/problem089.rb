#            "I"      "V"      "X"       "L"       "C"        "D"        "M"
RomanChar = {73 => 1, 86 => 5, 88 => 10, 76 => 50, 67 => 100, 68 => 500, 77 => 1000}

RomanMap = {1 => "I", 4 => "IV", 5 => "V", 9 => "IX", 10 => "X", 40 => "XL", 50 => "L", 90 => "XC", 100 => "C", 400 => "CD", 500 => "D", 900 => "CM", 1000 => "M"}
RomanValues = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]

def readRoman(roman)
  last = 1001
  number = 0
  roman.each_byte {|c| 
    v = RomanChar[c]
    if (v <= last)
      number += v
      last = v
    else
      ratio = last.to_f / v.to_f
      # substraction: the ratio between them must be 0.1 or 0.2
      if (ratio == 0.1 || ratio == 0.2)
        number -= last         # remove last value that was added
        number += v - last     # add as the diff of the last and the current
        last = v - last
      else
        return nil
      end
    end    
  }
  return number
end

def writeRoman(number)  
  roman = ""
  n = number
  RomanValues.each {|v| 
    while n - v >= 0
      n -= v
      roman += RomanMap[v]
    end
  }
  return roman
end

start = Time.now

count = 0
file = File.new("res/roman.txt")
file.each_line do |roman|
  roman.strip!  
  count += roman.length - writeRoman(readRoman(roman)).length
end
file.close
puts "answer is #{count}"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"
