class Resolver
	def initialize(n)
		@n = n
		@routes = 0
	end
	
	# TEST recursive
   def resolve_recurse()
		x = 0
		y = 0
		recurse([[x,y]])
		@routes
	end
	
	# TEST iterative
	def recurse(route)
		if route.size < @n + @n + 1
			x,y = route.last
			recurse(route + [[x + 1, y]]) if x < @n
			recurse(route + [[x, y + 1]]) if y < @n
		else
			@routes += 1
		end
	end
	
	def resolve_iter
		routes = 0
		stack = [[1, [0,0]]]

		while stack.size > 0
			route = stack.pop
			size,last = route
			if size < @n + @n
				x,y = last
				stack.push([size + 1, [x + 1, y]]) if x < @n
				stack.push([size + 1, [x, y + 1]]) if y < @n
			else
				routes += 1
			end			
		end
		routes
	end

	# Resolve by building a pyramid of all the number of routes possible. 
	#
        # The pyramid looks like:
	# (0)       1
	# (1)      1,1
	# (2)     1,2,1
	# (3)    1,3,3,1
	# (4)   1,4,6,4,1
	# (5)  1,5,10,10,5,1
	# (6) 1,6,15,20,15,6,1	
	#
	# Except the first and last which are always 1, each number of a row is the sum 
	# of the two numbers on top of it in the previous row.
	# At the specified row, we just sum the square of each number.
	#
	# The idea behind the pyramid is to cut the cube in half. Each number
	# on the cube represents the number of routes possible to reach it starting either
	# from the top left or the bottom right corner of it. 
	# 1--1--1
        # |  |  |
        # 1--2--1
        # |  |  |
        # 1--1--1
	#
	# For the 3x3 cube:
	# 01--01--01--01
        # |   |    |   |
        # 01--02--03--01
        # |   |    |   |
        # 01--03--02--01
        # |   |    |   |
        # 01--01--01--01 
	#
	def resolve
		return 1 if @n == 0
		row = [1,1]
		2.upto(@n) do
			current = [1]			
			1.upto(row.size-1) do |i|
				current << row[i-1] + row[i]
			end
			current << 1
			row = current
		end
		row.inject(0) {|sum, n| sum + n*n}
	end
end

r = Resolver.new(ARGV[0].to_i)
start = Time.now

routes = r.resolve
puts routes

stop = Time.now
time = stop.to_i - start.to_i
puts "Calculated in #{time} seconds"
