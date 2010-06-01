object Problem025 extends Application {
  
  var limit:BigInt = 10
  limit = limit.pow(999)
  lazy val fib: Stream[BigInt] = Stream.cons(0,Stream.cons(1, fib.zip(fib.tail).map(p => p._1 + p._2)))
  var i = 0
  fib.dropWhile(n => {i = i + 1; n < limit})
  println(i-1)
  
}
