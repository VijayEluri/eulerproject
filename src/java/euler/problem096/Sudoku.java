package euler.problem096;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

public class Sudoku {
	
	protected int[] grid;
	
	public static final int GRID_SIZE = 81; 
	
	public Sudoku(int[] grid) {
		if (grid.length != GRID_SIZE) {
			throw new RuntimeException("Invalid grid size: " + grid.length);
		}
		this.grid = grid; 
	}
	
	protected int[] getRow(int index) {
		if (index < 0 || index > 8) {
			throw new RuntimeException("Invalid row index: " + index);
		}
		int[] row = new int[9];
		for (int i = 0; i < row.length; i++) {
			row[i] = grid[index * 9 + i];
		}
		return row;
	}
	
	protected int[] getColumn(int index) {
		if (index < 0 || index > 8) {
			throw new RuntimeException("Invalid column index: " + index);
		}
		
		int[] column = new int[9];
		for (int i = 0; i < column.length; i++) {
			column[i] = grid[index + 9 * i];
		}
		return column;
	}
	
	protected int[] getSquare(int index) {
		switch (index) {
		case 0:
			return new int[] {grid[0],grid[1],grid[2],grid[9],grid[10],grid[11],grid[18],grid[19],grid[20]};
		case 1:
			return new int[] {grid[3],grid[4],grid[5],grid[12],grid[13],grid[14],grid[21],grid[22],grid[23]};
		case 2:
			return new int[] {grid[6],grid[7],grid[8],grid[15],grid[16],grid[17],grid[24],grid[25],grid[26]};
		case 3:
			return new int[] {grid[27],grid[28],grid[29],grid[36],grid[37],grid[38],grid[45],grid[46],grid[47]};
		case 4:
			return new int[] {grid[30],grid[31],grid[32],grid[39],grid[40],grid[41],grid[48],grid[49],grid[50]};
		case 5:
			return new int[] {grid[33],grid[34],grid[35],grid[42],grid[43],grid[44],grid[51],grid[52],grid[53]};
		case 6:
			return new int[] {grid[54],grid[55],grid[56],grid[63],grid[64],grid[65],grid[72],grid[73],grid[74]};
		case 7:
			return new int[] {grid[57],grid[58],grid[59],grid[66],grid[67],grid[68],grid[75],grid[76],grid[77]};
		case 8:
			return new int[] {grid[60],grid[61],grid[62],grid[69],grid[70],grid[71],grid[78],grid[79],grid[80]};
		default:
			throw new RuntimeException("Invalid square index: " + index);
		}
	}
	
	protected boolean isPresent(int[] unit, int number) {
		if (unit.length != 9) {
			throw new RuntimeException("Invalid unit length: " + unit.length);
		}
		for (int n : unit) {
			if (n == number) return true;
		}
		return false;
	}
	
	protected int getFreePositionsCount(int[] unit) {
		if (unit.length != 9) {
			throw new RuntimeException("Invalid unit length: " + unit.length);
		}
		int count = 0;
		for (int n : unit) {
			if (n == 0) count++;
		}
		return count;
	}
	
	protected int[][] getRowsForSquare(int index) {
		switch (index) {
		case 0:
		case 1:
		case 2:
			return new int[][] {getRow(0), getRow(1), getRow(2)};
		case 3:
		case 4:
		case 5:
			return new int[][] {getRow(3), getRow(4), getRow(5)};
		case 6:
		case 7:
		case 8:
			return new int[][] {getRow(6), getRow(7), getRow(8)};
		default:
			throw new RuntimeException("Invalid square index: " + index);
		}
	}
	
	protected int[][] getColumnsForSquare(int index) {
		switch (index) {
		case 0:
		case 3:
		case 6:
			return new int[][] {getColumn(0), getColumn(1), getColumn(2)};
		case 1:
		case 4:
		case 7:
			return new int[][] {getColumn(3), getColumn(4), getColumn(5)};
		case 2:
		case 5:
		case 8:
			return new int[][] {getColumn(6), getColumn(7), getColumn(8)};
		default:
			throw new RuntimeException("Invalid square index: " + index);
		}
	}
	
	protected int[][] getSquaresForRow(int index) {
		switch (index) {
		case 0:
		case 1:
		case 2:
			return new int[][] {getSquare(0), getSquare(1), getSquare(2)};
		case 3:
		case 4:
		case 5:
			return new int[][] {getSquare(3), getSquare(4), getSquare(5)};
		case 6:
		case 7:
		case 8:
			return new int[][] {getSquare(6), getSquare(7), getSquare(8)};
		default:
			throw new RuntimeException("Invalid row index: " + index);
		}
	}
	
	protected int[][] getSquaresForColumn(int index) {
		switch (index) {
		case 0:
		case 1:
		case 2:
			return new int[][] {getSquare(0), getSquare(3), getSquare(6)};
		case 3:
		case 4:
		case 5:
			return new int[][] {getSquare(1), getSquare(4), getSquare(7)};
		case 6:
		case 7:
		case 8:
			return new int[][] {getSquare(2), getSquare(5), getSquare(8)};
		default:
			throw new RuntimeException("Invalid column index: " + index);
		}
	}
	
	protected Map<Integer, Integer> buildSquarePositionsMap(int index) {
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		for (int i = 0; i < 9; i++) {
			switch (index) {
			case 0:
				pos.put(0, 0);
				pos.put(1, 1);
				pos.put(2, 2);
				pos.put(3, 9);
				pos.put(4, 10);
				pos.put(5, 11);
				pos.put(6, 18);
				pos.put(7, 19);
				pos.put(8, 20);
				break;
			case 1:
				pos.put(0, 3);
				pos.put(1, 4);
				pos.put(2, 5);
				pos.put(3, 12);
				pos.put(4, 13);
				pos.put(5, 14);
				pos.put(6, 21);
				pos.put(7, 22);
				pos.put(8, 23);
				break;
			case 2:
				pos.put(0, 6);
				pos.put(1, 7);
				pos.put(2, 8);
				pos.put(3, 15);
				pos.put(4, 16);
				pos.put(5, 17);
				pos.put(6, 24);
				pos.put(7, 25);
				pos.put(8, 26);
				break;
			case 3:
				pos.put(0, 27);
				pos.put(1, 28);
				pos.put(2, 29);
				pos.put(3, 36);
				pos.put(4, 37);
				pos.put(5, 38);
				pos.put(6, 45);
				pos.put(7, 46);
				pos.put(8, 47);
				break;
			case 4:
				pos.put(0, 30);
				pos.put(1, 31);
				pos.put(2, 32);
				pos.put(3, 39);
				pos.put(4, 40);
				pos.put(5, 41);
				pos.put(6, 48);
				pos.put(7, 49);
				pos.put(8, 50);
				break;
			case 5:
				pos.put(0, 33);
				pos.put(1, 34);
				pos.put(2, 35);
				pos.put(3, 42);
				pos.put(4, 43);
				pos.put(5, 44);
				pos.put(6, 51);
				pos.put(7, 52);
				pos.put(8, 53);
				break;
			case 6:
				pos.put(0, 54);
				pos.put(1, 55);
				pos.put(2, 56);
				pos.put(3, 63);
				pos.put(4, 64);
				pos.put(5, 65);
				pos.put(6, 72);
				pos.put(7, 73);
				pos.put(8, 74);
				break;
			case 7:
				pos.put(0, 57);
				pos.put(1, 58);
				pos.put(2, 59);
				pos.put(3, 66);
				pos.put(4, 67);
				pos.put(5, 68);
				pos.put(6, 75);
				pos.put(7, 76);
				pos.put(8, 77);
				break;
			case 8:
				pos.put(0, 60);
				pos.put(1, 61);
				pos.put(2, 62);
				pos.put(3, 69);
				pos.put(4, 70);
				pos.put(5, 71);
				pos.put(6, 78);
				pos.put(7, 79);
				pos.put(8, 80);
				break;
			default:
				throw new RuntimeException("Invalid square index: " + index);
			}
		}
		return pos;
	}
	
	protected int[] getPossiblePositionsForSquare(int index, int value) {
		int[][] rows = getRowsForSquare(index);
		int[][] cols = getColumnsForSquare(index);
		Map<Integer, Integer> pos = buildSquarePositionsMap(index);
		for (int i = 0; i < rows.length; i++) {
			int row[] = rows[i];
			if (isPresent(row, value)) {
				if (i == 0) {
					pos.remove(0);
					pos.remove(1);
					pos.remove(2);
				} else if (i == 1) {
					pos.remove(3);
					pos.remove(4);
					pos.remove(5);
				} else if (i == 2) {
					pos.remove(6);
					pos.remove(7);
					pos.remove(8);
				} else {
					throw new RuntimeException("Invalid row index: " + i);
				}
			}
		}
		for (int i = 0; i < cols.length; i++) {
			int col[] = cols[i];
			if (isPresent(col, value)) {
				if (i == 0) {
					pos.remove(0);
					pos.remove(3);
					pos.remove(6);
				} else if (i == 1) {
					pos.remove(1);
					pos.remove(4);
					pos.remove(7);
				} else if (i == 2) {
					pos.remove(2);
					pos.remove(5);
					pos.remove(8);
				} else {
					throw new RuntimeException("Invalid column index: " + i);
				}
			}
		}
		
		// Return available positions from map
		int[] avail = new int[pos.size()];
		Iterator<Integer> iter = pos.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			avail[i++] = pos.get(iter.next());
		}
		return avail;
	}
	
	protected Map<Integer, Integer> buildRowPositionsMap(int index) {
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		for (int i = 0; i < 9; i++) {
			switch (index) {
			case 0:
				pos.put(0, 0);
				pos.put(1, 1);
				pos.put(2, 2);
				pos.put(3, 3);
				pos.put(4, 4);
				pos.put(5, 5);
				pos.put(6, 6);
				pos.put(7, 7);
				pos.put(8, 8);
				break;
			case 1:
				pos.put(0, 9);
				pos.put(1, 10);
				pos.put(2, 11);
				pos.put(3, 12);
				pos.put(4, 13);
				pos.put(5, 14);
				pos.put(6, 15);
				pos.put(7, 16);
				pos.put(8, 17);
				break;
			case 2:
				pos.put(0, 18);
				pos.put(1, 19);
				pos.put(2, 20);
				pos.put(3, 21);
				pos.put(4, 22);
				pos.put(5, 23);
				pos.put(6, 24);
				pos.put(7, 25);
				pos.put(8, 26);
				break;
			case 3:
				pos.put(0, 27);
				pos.put(1, 28);
				pos.put(2, 29);
				pos.put(3, 30);
				pos.put(4, 31);
				pos.put(5, 32);
				pos.put(6, 33);
				pos.put(7, 34);
				pos.put(8, 35);
				break;
			case 4:
				pos.put(0, 36);
				pos.put(1, 37);
				pos.put(2, 38);
				pos.put(3, 39);
				pos.put(4, 40);
				pos.put(5, 41);
				pos.put(6, 42);
				pos.put(7, 43);
				pos.put(8, 44);
				break;
			case 5:
				pos.put(0, 45);
				pos.put(1, 46);
				pos.put(2, 47);
				pos.put(3, 48);
				pos.put(4, 49);
				pos.put(5, 50);
				pos.put(6, 51);
				pos.put(7, 52);
				pos.put(8, 53);
				break;
			case 6:
				pos.put(0, 54);
				pos.put(1, 55);
				pos.put(2, 56);
				pos.put(3, 57);
				pos.put(4, 58);
				pos.put(5, 59);
				pos.put(6, 60);
				pos.put(7, 61);
				pos.put(8, 62);
				break;
			case 7:
				pos.put(0, 63);
				pos.put(1, 64);
				pos.put(2, 65);
				pos.put(3, 66);
				pos.put(4, 67);
				pos.put(5, 68);
				pos.put(6, 69);
				pos.put(7, 70);
				pos.put(8, 71);
				break;
			case 8:
				pos.put(0, 72);
				pos.put(1, 73);
				pos.put(2, 74);
				pos.put(3, 75);
				pos.put(4, 76);
				pos.put(5, 77);
				pos.put(6, 78);
				pos.put(7, 79);
				pos.put(8, 80);
				break;
			default:
				throw new RuntimeException("Invalid row index: " + index);
			}
		}
		return pos;
	}
	
	protected int[] getPossiblePositionsForRow(int index, int value) {
		int[][] squares = getSquaresForRow(index);
		Map<Integer, Integer> pos = buildRowPositionsMap(index);
		for (int i = 0; i < squares.length; i++) {
			int square[] = squares[i];
			if (isPresent(square, value)) {
				if (i == 0) {
					pos.remove(0);
					pos.remove(1);
					pos.remove(2);
				} else if (i == 1) {
					pos.remove(3);
					pos.remove(4);
					pos.remove(5);
				} else if (i == 2) {
					pos.remove(6);
					pos.remove(7);
					pos.remove(8);
				} else {
					throw new RuntimeException("Invalid row index: " + i);
				}
			}
		}
		
		// Check all columns
		for (int i = 0; i < 9; i++) {
			int col[] = getColumn(i);
			if (isPresent(col, value)) {
				pos.remove(i);
			}
		}
		
		// Return available positions from map
		int[] avail = new int[pos.size()];
		Iterator<Integer> iter = pos.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			avail[i++] = pos.get(iter.next());
		}
		return avail;
	}
	
	protected Map<Integer, Integer> buildColumnPositionsMap(int index) {
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		for (int i = 0; i < 9; i++) {
			switch (index) {
			case 0:
				pos.put(0, 0);
				pos.put(1, 9);
				pos.put(2, 18);
				pos.put(3, 27);
				pos.put(4, 36);
				pos.put(5, 45);
				pos.put(6, 54);
				pos.put(7, 63);
				pos.put(8, 72);
				break;
			case 1:
				pos.put(0, 1);
				pos.put(1, 10);
				pos.put(2, 19);
				pos.put(3, 28);
				pos.put(4, 37);
				pos.put(5, 46);
				pos.put(6, 55);
				pos.put(7, 64);
				pos.put(8, 73);
				break;
			case 2:
				pos.put(0, 2);
				pos.put(1, 11);
				pos.put(2, 20);
				pos.put(3, 29);
				pos.put(4, 38);
				pos.put(5, 47);
				pos.put(6, 56);
				pos.put(7, 65);
				pos.put(8, 74);
				break;
			case 3:
				pos.put(0, 3);
				pos.put(1, 12);
				pos.put(2, 21);
				pos.put(3, 30);
				pos.put(4, 39);
				pos.put(5, 48);
				pos.put(6, 57);
				pos.put(7, 66);
				pos.put(8, 75);
				break;
			case 4:
				pos.put(0, 4);
				pos.put(1, 13);
				pos.put(2, 22);
				pos.put(3, 31);
				pos.put(4, 40);
				pos.put(5, 49);
				pos.put(6, 58);
				pos.put(7, 67);
				pos.put(8, 76);
				break;
			case 5:
				pos.put(0, 5);
				pos.put(1, 14);
				pos.put(2, 23);
				pos.put(3, 32);
				pos.put(4, 41);
				pos.put(5, 50);
				pos.put(6, 59);
				pos.put(7, 68);
				pos.put(8, 77);
				break;
			case 6:
				pos.put(0, 6);
				pos.put(1, 15);
				pos.put(2, 24);
				pos.put(3, 33);
				pos.put(4, 42);
				pos.put(5, 51);
				pos.put(6, 60);
				pos.put(7, 69);
				pos.put(8, 78);
				break;
			case 7:
				pos.put(0, 7);
				pos.put(1, 16);
				pos.put(2, 25);
				pos.put(3, 34);
				pos.put(4, 43);
				pos.put(5, 52);
				pos.put(6, 61);
				pos.put(7, 70);
				pos.put(8, 79);
				break;
			case 8:
				pos.put(0, 8);
				pos.put(1, 17);
				pos.put(2, 26);
				pos.put(3, 35);
				pos.put(4, 44);
				pos.put(5, 53);
				pos.put(6, 62);
				pos.put(7, 71);
				pos.put(8, 80);
				break;
			default:
				throw new RuntimeException("Invalid row index: " + index);
			}
		}
		return pos;
	}
	
	protected int[] getPossiblePositionsForColumn(int index, int value) {
		int[][] squares = getSquaresForColumn(index);
		Map<Integer, Integer> pos = buildColumnPositionsMap(index);
		for (int i = 0; i < squares.length; i++) {
			int square[] = squares[i];
			if (isPresent(square, value)) {
				if (i == 0) {
					pos.remove(0);
					pos.remove(1);
					pos.remove(2);
				} else if (i == 1) {
					pos.remove(3);
					pos.remove(4);
					pos.remove(5);
				} else if (i == 2) {
					pos.remove(6);
					pos.remove(7);
					pos.remove(8);
				} else {
					throw new RuntimeException("Invalid column index: " + i);
				}
			}
		}
		
		// Check all rows
		for (int i = 0; i < 9; i++) {
			int row[] = getRow(i);
			if (isPresent(row, value)) {
				pos.remove(i);
			}
		}
		
		// Return available positions from map
		int[] avail = new int[pos.size()];
		Iterator<Integer> iter = pos.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			avail[i++] = pos.get(iter.next());
		}
		return avail;
	}
	
	protected int solveBySquareDeduction() {
		int total = 0;
		while (true) {
			int nbUpdated = 0;
			for (int squareIdx = 0; squareIdx < 9; squareIdx++) {
				int[] square = getSquare(squareIdx);
				// Check for each value in the square
				for (int value = 1; value <= 9; value++) {
					if (isPresent(square, value) == false) {
						
						// Get available positions
						int[] positions = getPossiblePositionsForSquare(squareIdx, value);
						if (positions.length == 0) {
							throw new RuntimeException("No position possible!");
						}
						
						// Count available positions
						int position = 0;
						int nb = 0;
						for (int p : positions) {
							if (grid[p] == 0) {
								nb++;
								position = p;
							}
						}
						
						// There must only 1 postion available in order to set it to value
						if (nb == 0) {
							throw new RuntimeException("No position available!");
						} else if (nb == 1) {
							// Update value
//							System.out.println(String.format("Set %d to %d", position, value));
							if (grid[position] != 0) {
								throw new RuntimeException("Trying to set a value twice!");
							}
							grid[position] = value;
							nbUpdated++;
							
						} // else: nb > 1 -> can't pinpoint a position to set!
					}
				}
			}
			total += nbUpdated;
			if (nbUpdated == 0) {
				break;
			}
		}
//		System.out.println("S: " + toSolverString());
		return total;
	}
	
	protected void solveBySquareBruteForce() {
		for (int squareIdx = 0; squareIdx < 9; squareIdx++) {
			int[] square = getSquare(squareIdx);
			// Check for each value in the square
			for (int value = 1; value <= 9; value++) {
				if (isPresent(square, value) == false) {

					// Get available positions
					int[] positions = getPossiblePositionsForSquare(squareIdx, value);
					if (positions.length == 0) {
						throw new RuntimeException("No position possible!");
					}

					int[] copy = null;
					for (int p : positions) {
						// Check if available
						if (grid[p] != 0) continue;
						
						copy = ArrayUtils.clone(grid);
						copy[p] = value;
						Sudoku s = new Sudoku(copy);
						try {
							s.solveByDeduction();
							if (s.isValid()) {
								this.grid = copy;
								return;
							}
						} catch (RuntimeException e) {
//							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
	}
	
	protected int solveByRowDeduction() {
		int total = 0;
		while (true) {
			int nbUpdated = 0;
			for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
				int[] row = getRow(rowIdx);
				// Check for each value in the row
				for (int value = 1; value <= 9; value++) {
					if (isPresent(row, value) == false) {
						
						// Get available positions
						int[] positions = getPossiblePositionsForRow(rowIdx, value);
						if (positions.length == 0) {
							throw new RuntimeException("No position possible!");
						}
						
						// Count available positions
						int position = 0;
						int nb = 0;
						for (int p : positions) {
							if (grid[p] == 0) {
								nb++;
								position = p;
							}
						}
						
						// There must only 1 postion available in order to set it to value
						if (nb == 0) {
							throw new RuntimeException("No position available!");
						} else if (nb == 1) {
							// Update value
//							System.out.println(String.format("Set %d to %d", position, value));
							if (grid[position] != 0) {
								throw new RuntimeException("Trying to set a value twice!");
							}
							grid[position] = value;
							nbUpdated++;
							
						} // else: nb > 1 -> can't pinpoint a position to set!
					}
				}
			}
			total += nbUpdated;
			if (nbUpdated == 0) {
				break;
			}
		}
//		System.out.println("R: " + toSolverString());
		return total;
	}
	
	protected int solveByColumnDeduction() {
		int total = 0;
		while (true) {
			int nbUpdated = 0;
			for (int columnIdx = 0; columnIdx < 9; columnIdx++) {
				int[] row = getColumn(columnIdx);
				// Check for each value in the column
				for (int value = 1; value <= 9; value++) {
					if (isPresent(row, value) == false) {
						
						// Get available positions
						int[] positions = getPossiblePositionsForColumn(columnIdx, value);
						if (positions.length == 0) {
							throw new RuntimeException("No position possible!");
						}
						
						// Count available positions
						int position = 0;
						int nb = 0;
						for (int p : positions) {
							if (grid[p] == 0) {
								nb++;
								position = p;
							}
						}
						
						// There must only 1 postion available in order to set it to value
						if (nb == 0) {
							throw new RuntimeException("No position available!");
						} else if (nb == 1) {
							// Update value
//							System.out.println(String.format("Set %d to %d", position, value));
							if (grid[position] != 0) {
								throw new RuntimeException("Trying to set a value twice!");
							}
							grid[position] = value;
							nbUpdated++;
							
						} // else: nb > 1 -> can't pinpoint a position to set!
					}
				}
			}
			total += nbUpdated;
			if (nbUpdated == 0) {
				break;
			}
		}
//		System.out.println("C: " + toSolverString());
		return total;
	}
	
	protected void solveByDeduction() {
		while (true) {
			int total = 0;
			total += solveBySquareDeduction();
			total += solveByRowDeduction();
			total += solveByColumnDeduction();
			if (total == 0) {
				break;
			}
		}
	}
	
	public void solve() {
		solveByDeduction();
		if (isCompleted() == false) {
			solveBySquareBruteForce();
		}
	}
	
	public boolean isCompleted() {
		for (int value : grid) {
			if (value == 0) return false;
		}
		return true;
	}
	
	public boolean isValid() {
		// it must be complete to be valid
		if (!isCompleted()) return false;
		
		// Check rows
		for (int i = 0; i < 9; i++) {
			int[] row = getRow(i);
			Set<Integer> set = new HashSet<Integer>();
			for (int value : row) {
				if (set.add(value) == false) {
					return false;
				}
			}
		}
		
		// Check columns
		for (int i = 0; i < 9; i++) {
			int[] column = getColumn(i);
			Set<Integer> set = new HashSet<Integer>();
			for (int value : column) {
				if (set.add(value) == false) {
					return false;
				}
			}
		}
		
		// Check squares
		for (int i = 0; i < 9; i++) {
			int[] square = getSquare(i);
			Set<Integer> set = new HashSet<Integer>();
			for (int value : square) {
				if (set.add(value) == false) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int getFirst3Number() {
		return Integer.parseInt(String.valueOf(grid[0]) + String.valueOf(grid[1]) + String.valueOf(grid[2]));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 9; i++) {
			int row[] = getRow(i);
			for (int value : row) {
				sb.append(value);
				sb.append(",");
			}
			sb.append("\r\n");
		}
		return sb.toString();
	}
	
	/**
	 * Used for http://www.sudokusolver.co.uk/
	 * @return string
	 */
	public String toSolverString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 9; i++) {
			int row[] = getRow(i);
			for (int value : row) {
				if (value == 0) {
					sb.append("_");
				} else {
					sb.append(value);
				}
			}
			if (i < 8) {
				sb.append("+");
			}
		}
		return sb.toString();
	}
	
}
