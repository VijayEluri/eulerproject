start = Time.now

# initialize the sieve
limit = 105000         
is_prime = Array.new(limit, false) 

# Add known primes
is_prime[2] = true
is_prime[3] = true

# put in candidate primes: 
# integers which have an odd number of representations by certain quadratic forms
for x in (1..Math.sqrt(limit))
  for y in (1..Math.sqrt(limit))
    # 4x^2 + y^2
    n = 4*x**2+y**2
    m = n.modulo(12)
    if n <= limit and (m == 1 or m == 5)
      is_prime[n] = !is_prime[n]
    end
    # 3x^2 + y^2
    n = 3*x**2+y**2
    if n <= limit and n.modulo(12) == 7
      is_prime[n] = !is_prime[n]
    end
    # 3x^2 - y^2
    n = 3*x**2-y**2
    if x > y and n <= limit and n.modulo(12) == 11
      is_prime[n] = !is_prime[n]
    end
  end
end

# eliminate composites by sieving
for n in (5..Math.sqrt(limit))
  if is_prime[n]
    k = n**2
    # n is prime, omit multiples of its square; this is sufficient because
    # composites which managed to get on the list cannot be square-free
    while (k <= limit)
      is_prime[k] = false
      k += n**2
    end
  end
end

# list primes
i = 0
rank = 10001
for n in (0..limit)
  i += 1 if is_prime[n]  
  if (i == rank)
    puts "The #{rank}th prime is #{n}"
    break
  end
end

# Alternate way with ruby (but slow...)
#require 'mathn'
#primes = Prime.new
#10_000.times { primes.next }
#puts "Prime is #{ primes.next }."

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"