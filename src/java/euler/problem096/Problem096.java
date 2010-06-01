package euler.problem096;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Problem096 {
	
	static public int resolve() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("res/sudoku.txt"));
			String line = null;
			int sum = 0;
			int[] grid = new int[Sudoku.GRID_SIZE];
			int i = 0;
			int count = 0;
			String name = "";
			while ((line = reader.readLine()) != null) {
				// Get grid name
				if (line.charAt(0) == 'G'){
					name = line;
					continue;
				}
				
				// Read row
				if (line.length() != 9) throw new RuntimeException("Invalid line: " + line);
				for (int j = 0; j < line.length(); j++) {
					grid[i++] = Character.digit(line.charAt(j), 10);
				}
				
				// Solve Sudoku at last row
				if (i == Sudoku.GRID_SIZE) {
					Sudoku sudoku = new Sudoku(grid);
					sudoku.solve();
					if (sudoku.isCompleted() == false) {
						System.out.println(String.format("%s is NOT completed!", name));
						count++;
					} else {
						if (sudoku.isValid()) {
							sum += sudoku.getFirst3Number();
						} else {
							System.out.println(String.format("%s is NOT VALID!!!", name));
						}
					}
					// Reset for next grid
					i = 0;
				}
			}
			reader.close();
			System.out.println("Number of not completed grids: " + count);
			return sum;
			
		} catch (IOException e) {
			throw new RuntimeException(e.getCause());
		}
	}
	
	static public void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + resolve());
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
	}
	
}
