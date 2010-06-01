start = Time.now

# the first 2000th primes
require 'mathn'
primes = Prime.new
Primes = Array.new
list = ""
for i in (1..2000)
  Primes << primes.next
end

# see http://en.wikipedia.org/wiki/Divisor for details
def getFactorCount(number)
  if number == 0
    return 0
  end
  if number == 1
    return 1
  end
  
  i = 0  
  count = 1
  n = number
  while n != 1
    prime = Primes[i]
    v = 0
    while n.modulo(prime) == 0 
      n = n / prime   
      v += 1
    end
    count *= v + 1
    i += 1    
  end
  #puts prime
  return count
end

factors = 0
i = 0
triangle = 0
while factors <= 500
  i += 1
  triangle = triangle + i    
  factors = getFactorCount(triangle)  
end
puts "answer is #{triangle} (the #{i}th triangle number)"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"