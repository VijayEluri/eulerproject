package euler;

public class Problem006 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	long start = System.currentTimeMillis();

	System.out.println(squareOfSum(100) - sumOfSquares(100));

	System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void solve(int n) {

    }
    
    public static int sumOfSquares(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
	    sum += i*i;
	}
	return sum;
    }
    
    public static int squareOfSum(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
	    sum += i;
	}
	return sum*sum;
    }

}
