package euler;

public class Problem001 {
	
	static public int resolve(final int limit) {
		int total = 0;
		for (int i = 3; i < limit; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				total += i;
			}
		}
		return total;
	}
	
	static public void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + resolve(1000));
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
	}
	
}
