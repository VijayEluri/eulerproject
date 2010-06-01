package euler;

public class Problem004 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	long start = System.currentTimeMillis();

	solve(999);

	System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void solve(int n) {
	for (int i = n*n; i > 0; i--) {
	    if (isPalindromic(i)) {
		for (int j = n; j > 0; j--) {
		    if (i % j == 0 && i / j <= n) {
			System.out.println(i/j + "x" + j + " = " + i);
			return;
		    }
		}
	    }
	}
    }

    public static boolean isPalindromic(int n) {
	String s = String.valueOf(n);
	for (int i = 0; i < s.length() / 2; i++) {
	    int last = s.length() - 1 - i;
	    if (s.charAt(i) != s.charAt(last)) return false;
	}
	return true;
    }

}
