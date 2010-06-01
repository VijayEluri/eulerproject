package euler

start = System.currentTimeMillis()

n = new BigDecimal(2**1000).toPlainString()

sum = 0
n.each { c -> sum += c.toInteger() }
println(sum)
println((System.currentTimeMillis() - start) + " ms")