package euler;

import java.util.List;


public class Problem005 {
    
    public static void main(String[] args) {
	long start = System.currentTimeMillis();

	//solve(20);
	solve_euler(20);

	System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void solve(int n) {

	for (long i = 1; i < Long.MAX_VALUE; i++) {
	    boolean found = true;
	    for (int j = 1; j <= n; j++) {
		if (i%j != 0) {
		    found = false;
		    break;
		}
	    }
	    if (found) {
		System.out.println(i);
		return;
	    }
	}
	System.out.println("non trouv�...");
    }
    
    /**
     * On r�soud en multipliant tous les facteurs
     * @param n
     */
    public static void solve_euler(int n) {
	long result = 1;
	List<Long> primes = EulerUtils.eratosthenes_prime_generator(n);
	for (long prime : primes) {
	    int power = (int) Math.floor(Math.log(n) / Math.log(prime));
	    result *= Math.pow(prime, power);
	}
	System.out.println(result);
    }
}
