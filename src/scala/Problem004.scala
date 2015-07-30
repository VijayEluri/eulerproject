object Problem004 {

	def isPalindrome(s: String) = s == s.reverse

	def main(args: Array[String]) {
		val n = 999;
		for (i <- n*n to 1 by -1) {
			if (isPalindrome(i.toString)) {
				for (j <- n+1 to 1 by -1) {
					if (i % j == 0 && i / j <= n) {
						println(s"${i/j} x ${j} = ${i}")
						return
					}
				}
			}			
		}
	}
}