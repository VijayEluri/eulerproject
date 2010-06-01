
object Problem020 {
  
  def fact(n:BigInt):BigInt = {
    if (n==1) 1 else n*fact(n-1)
  }
  
  def sum(s:String,n:Int):Int = {
    if (n<0) 0 else Character.getNumericValue(s(n)) + sum(s, n-1)
  }
  
  def main(args: Array[String]) {
    val s = fact(100).toString
    println(sum(s, s.length-1))
    
  }
}

