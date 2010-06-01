package euler

start = System.currentTimeMillis()

fact = new BigDecimal(1)
2.upto(100) {fact *= it}
fact = fact.toPlainString()

sum = 0
fact.each { c -> sum += c.toInteger() }
println(sum)

println((System.currentTimeMillis() - start) + " ms")