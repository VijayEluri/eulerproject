import scala.io.Source

object Problem011 {
  
	def row(grid:List[List[Int]], i:Int, j:Int):Int = {
		if (j>16) 0 else grid(i)(j)*grid(i)(j+1)*grid(i)(j+2)*grid(i)(j+3)
	}
  
	def column(grid:List[List[Int]], i:Int, j:Int):Int = {
		if (i>16) 0 else grid(i)(j)*grid(i+1)(j)*grid(i+2)(j)*grid(i+3)(j)
	}
  
	def diagonal1(grid:List[List[Int]], i:Int, j:Int):Int = {
		if (i>16 || j>16) 0 else grid(i)(j)*grid(i+1)(j+1)*grid(i+2)(j+2)*grid(i+3)(j+3)
	}
  
	def diagonal2(grid:List[List[Int]], i:Int, j:Int):Int = {
		if (i>16 || j<3) 0 else grid(i)(j)*grid(i+1)(j-1)*grid(i+2)(j-2)*grid(i+3)(j-3)
	}

	def main(args: Array[String]) {
  
		val src = Source.fromFile("Problem011.txt")
  
		// Load grid
		val grid = src.getLines.foldLeft(List[List[Int]]()) { (g, line) => 
			line.split("\\s").foldLeft(List[Int]()) {(l, s) => 
				s.toInt :: l
			} :: g
		}
  
		//println(grid(1)(19))
  
		var p = 0
		(0 to 19).foreach {i =>
			(0 to 19).foreach {j =>
				val x = row(grid, i, j)
				if (x>p) p = x      
				val y = column(grid, i, j)
				if (y>p) p = y
				val z = diagonal1(grid, i, j)
				if (z>p) p = z
				val w = diagonal2(grid, i, j)
				if (w>p) p = w
			}
		}
  
		println(p)
	}
}
