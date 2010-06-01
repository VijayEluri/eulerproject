def collatz(n)
  i = 1
  while (n>1)
    i += 1
    if (n%2==1)
      n=3*n+1
    else
      n=n/2
    end
  end
  i
end

start = Time.now

max = 0
n = 0
for i in (1..999999)
  l = collatz(i)
  if (l>max)
    max = l
    n = i
  end
end

puts "#{n} (#{max})"

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"