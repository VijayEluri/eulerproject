package euler;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Problem003 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	long start = System.currentTimeMillis();

	long n = 600851475143L;
	// solve_using_eratosthenes_prime_generator(n);
	solve_using_euler_project_method(n);

	System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void solve_using_eratosthenes_prime_generator(long n) {
	long square = (long) Math.floor(Math.sqrt(n));

	// Generate all primes up to square of n
	List<Long> primes = eratosthenes_prime_generator(square);

	// Going backward, find the biggest factor of n
	for (int i = primes.size() - 1; i >= 0; i--) {
	    Long p = primes.get(i);
	    if (n % p == 0) {
		System.out.println(p);
		break;
	    }
	}
    }

    /**
     * Generate all primes number up to n
     * @param n
     * @return all primes number up to n
     */
    public static List<Long> eratosthenes_prime_generator(long n) {
	List<Long> primes = new LinkedList<Long>();
	primes.add(new Long(2));

	// Initialize a list with all odd numbers from 3 to n
	List<Long> propables = new LinkedList<Long>();
	for (long i = 3; i <= n; i += 2) {
	    propables.add(i);
	}

	// Iterate while the list is not empty or that the head is less then square of n
	while (propables.size() > 0 && propables.get(0) <= Math.floor(Math.sqrt(n))) {
	    // The top element is always prime
	    Long p = propables.remove(0);
	    primes.add(p);

	    // Remove all multiples of this prime
	    for (ListIterator<Long> iter = propables.listIterator(); iter.hasNext();) {
		if (iter.next() % p == 0) iter.remove();
	    }
	}

	// All the numbers remaining are prime.
	primes.addAll(propables);
	return primes;
    }

    public static void solve_using_euler_project_method(long n) {
	long lastFactor = 1;

	// Try with factor 2
	while (n % 2 == 0) {
	    lastFactor = 2;
	    n /= 2;
	}

	long factor = 3;
	long maxFactor = (long) Math.sqrt(n);

	// Try with all odd factors
	while (n > 1 && factor <= maxFactor) {
	    while (n % factor == 0) {
		lastFactor = factor;
		n /= factor;
	    }
	    factor += 2;
	}

	if (n == 1) {
	    System.out.println(lastFactor);
	} else {
	    System.out.println(n);
	}
    }

}
