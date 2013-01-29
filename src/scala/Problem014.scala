object Problem014 {
  
  def collatz(n:Int):List[Int] = {
    def inner(n:Int,l:List[Int]):List[Int] = {
      if (n==1) l
      else {
        var k = 0
        if (n%2==0) {
          k = n/2          
        } else {
          k = 3*n+1
        }
        inner(k,k::l)
      }
    }
    val l = List(n)
    inner(n,l)
  }
  
  def collatz2(n:Int):Int = {
    var k:BigInt = n
    var i = 1
    while (k>1) {
      i = i+1      
      if (k%2==1) {
        k = k*3+1
      } else {
        k = k/2
      }
    }
    i
  }
                  
	def main(args: Array[String]) {
                            
		val start = System.currentTimeMillis()
  
		val max = (1 to 999999).foldLeft((0,0)) {(max,i) =>
			val l = collatz2(i)
			if (l > max._1) (l,i) else max
		}
  
		println("n = " + max._2 + " (" + max._1 + ")")
		println((System.currentTimeMillis() - start) + " ms")
	}
}
