start = Time.now.to_f

sum = 0;
prev = 1;
n = 2;
while (n <= 4000000)
  if (n%2 == 0)
    sum += n;
  end
  tmp = n;
  n = prev + n;
  prev = tmp;
end

puts sum
puts "#{(Time.now.to_f - start) * 1000} ms"