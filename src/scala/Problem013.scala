import scala.io.Source

object Problem013 {
  
	def main(args: Array[String]) {

		val src = Source.fromFile("Problem013.txt")
  
		/*
		var sum = BigInt(0)
		for (line <- src.getLines) { 
			val n = BigInt(line.replaceAll("\\s",""))
			sum = sum + n
		}
		println(sum.toString.substring(0,10))
		*/
  
		val sum = src.getLines.foldLeft(BigInt(0)) { (n, line) =>  n + BigInt(line.replaceAll("\\s","")) }
		println(sum.toString.substring(0,10))
	}
}
