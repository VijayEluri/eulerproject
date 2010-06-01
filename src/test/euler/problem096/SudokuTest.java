package euler.problem096;

import java.util.Arrays;

import euler.problem096.Sudoku;

import junit.framework.TestCase;

public class SudokuTest extends TestCase {

	final int[] grid01 = new int[] {0,0,3,0,2,0,6,0,0,
								  	9,0,0,3,0,5,0,0,1,
								  	0,0,1,8,0,6,4,0,0,
								  	0,0,8,1,0,2,9,0,0,
								  	7,0,0,0,0,0,0,0,8,
								  	0,0,6,7,0,8,2,0,0,
								  	0,0,2,6,0,9,5,0,0,
								  	8,0,0,2,0,3,0,0,9,
								  	0,0,5,0,1,0,3,0,0};
	
	final int[] grid03 = new int[] {0,0,0,0,0,0,9,0,7,
								  	0,0,0,4,2,0,1,8,0,
								  	0,0,0,7,0,5,0,2,6,
								  	1,0,0,9,0,4,0,0,0,
								  	0,5,0,0,0,0,0,4,0,
								  	0,0,0,5,0,7,0,0,9,
								  	9,2,0,1,0,8,0,0,0,
								  	0,3,4,0,5,9,0,0,0,
								  	5,0,7,0,0,0,0,0,0};
	
	Sudoku sudoku;
	
	@Override
	protected void setUp() throws Exception {
		sudoku = new Sudoku(grid01);
	}
	
	public void testGetRow() {
		// 1st row from grid
		int[] row = new int[] {0,0,3,0,2,0,6,0,0};
		assertTrue(Arrays.equals(row, sudoku.getRow(0)));
		// 5th row from grid
		row = new int[] {7,0,0,0,0,0,0,0,8};
		assertTrue(Arrays.equals(row, sudoku.getRow(4)));
		// 9th row from grid
		row = new int[] {0,0,5,0,1,0,3,0,0};
		assertTrue(Arrays.equals(row, sudoku.getRow(8)));
	}
	
	public void testGetColumn() {
		// 1st column from grid
		int[] column = new int[] {0,9,0,0,7,0,0,8,0};
		assertTrue(Arrays.equals(column, sudoku.getColumn(0)));
		// 3rd column from grid
		column = new int[] {3,0,1,8,0,6,2,0,5};
		assertTrue(Arrays.equals(column, sudoku.getColumn(2)));
		// 9th column from grid
		column = new int[] {0,1,0,0,8,0,0,9,0};
		assertTrue(Arrays.equals(column, sudoku.getColumn(8)));
	}
	
	public void testGetSquare() {
		// 1st square from grid
		int[] square = new int[] {0,0,3,9,0,0,0,0,1};
		assertTrue(Arrays.equals(square, sudoku.getSquare(0)));
		// 2nd square from grid
		square = new int[] {0,2,0,3,0,5,8,0,6};
		assertTrue(Arrays.equals(square, sudoku.getSquare(1)));
		// 3rd square from grid
		square = new int[] {6,0,0,0,0,1,4,0,0};
		assertTrue(Arrays.equals(square, sudoku.getSquare(2)));
		// 4th square from grid
		square = new int[] {0,0,8,7,0,0,0,0,6};
		assertTrue(Arrays.equals(square, sudoku.getSquare(3)));
		// 5th square from grid
		square = new int[] {1,0,2,0,0,0,7,0,8};
		assertTrue(Arrays.equals(square, sudoku.getSquare(4)));
		// 6th square from grid
		square = new int[] {9,0,0,0,0,8,2,0,0};
		assertTrue(Arrays.equals(square, sudoku.getSquare(5)));
		// 7th square from grid
		square = new int[] {0,0,2,8,0,0,0,0,5};
		assertTrue(Arrays.equals(square, sudoku.getSquare(6)));
		// 8th square from grid
		square = new int[] {6,0,9,2,0,3,0,1,0};
		assertTrue(Arrays.equals(square, sudoku.getSquare(7)));
		// 9th square from grid
		square = new int[] {5,0,0,0,0,9,3,0,0};
		assertTrue(Arrays.equals(square, sudoku.getSquare(8)));
	}
	
	public void testSolveBySquareDeduction() {
		int[] solu01 = new int[] {4,8,3,9,2,1,6,5,7,
								  9,6,7,3,4,5,8,2,1,
								  2,5,1,8,7,6,4,9,3,
								  5,4,8,1,3,2,9,7,6,
								  7,2,9,5,6,4,1,3,8,
								  1,3,6,7,9,8,2,4,5,
								  3,7,2,6,8,9,5,1,4,
								  8,1,4,2,5,3,7,6,9,
								  6,9,5,4,1,7,3,8,2};
		
		sudoku.solveBySquareDeduction();
		System.out.println(sudoku.getFirst3Number());
		assertTrue(sudoku.isCompleted());
		assertTrue(Arrays.equals(solu01, sudoku.grid));
	}
	
	public void testCompleted() {
		sudoku = new Sudoku(grid03);
		sudoku.solve();
		System.out.println(sudoku);
		assertTrue(sudoku.isCompleted());
	}
	
	public void testGrid47() {
		int[] grid47 = new int[] {0,0,0,7,0,0,8,0,0,
							  	  0,0,6,0,0,0,0,3,1,
								  0,4,0,0,0,2,0,0,0,
								  0,2,4,0,7,0,0,0,0,
								  0,1,0,0,3,0,0,8,0,
								  0,0,0,0,6,0,2,9,0,
								  0,0,0,8,0,0,0,7,0,
								  8,6,0,0,0,0,5,0,0,
								  0,0,2,0,0,6,0,0,0};
		
		int[] solu47 = new int[] {1,5,9,7,4,3,8,6,2,
								  2,7,6,5,8,9,4,3,1,
								  3,4,8,6,1,2,7,5,9,
								  6,2,4,9,7,8,3,1,5,
								  9,1,7,2,3,5,6,8,4,
								  5,8,3,1,6,4,2,9,7,
								  4,3,5,8,2,1,9,7,6,
								  8,6,1,4,9,7,5,2,3,
								  7,9,2,3,5,6,1,4,8};
		
		sudoku = new Sudoku(grid47);
		sudoku.solve();
		assertTrue(sudoku.isCompleted());
		assertTrue(Arrays.equals(solu47, sudoku.grid));
	}
}
