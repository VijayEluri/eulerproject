package euler.problem096;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] grid = {5,0,0,3,0,0,9,0,0,
					  0,0,0,0,0,0,0,1,0,
					  4,6,0,2,0,0,0,3,0,
					  0,0,0,8,3,0,0,6,9,
					  0,0,0,9,0,2,0,0,0,
					  9,2,0,0,4,5,0,0,0,
					  0,3,0,0,0,6,0,8,4,
					  0,4,0,0,0,0,0,0,0,
					  0,0,7,0,0,1,0,0,3};
		
		Sudoku sudoku = new Sudoku(grid);
		long start = System.currentTimeMillis();
		sudoku.solve();
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(sudoku);
	}

}
