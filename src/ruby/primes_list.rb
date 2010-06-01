class PrimesList
  
  def initialize(rng)
    @rng = rng
  end
  
  def list
    # initialize the sieve    
    limit = @rng.entries.size
    is_prime = Array.new(limit, false) 
    
    # Add known primes 2 and 3
    if @rng === 2
      puts 2 - @rng.first
      is_prime[2 - @rng.first] = true
    end
    if @rng === 3      
      is_prime[3 - @rng.first] = true # 3
    end
    
    # put in candidate primes: 
    # integers which have an odd number of representations by certain quadratic forms
    for x in in (1..Math.sqrt(@rng.entries.size))
      for y in (1..Math.sqrt(@rng.entries.size))
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
    for n in (5..Math.sqrt(@rng.entries.size))
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
    
    return is_prime
  end
end

primes = PrimesList.new(0..6).list
puts primes[2]
