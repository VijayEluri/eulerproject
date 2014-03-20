package euler;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

/**
 * Same as Problem001, but using Java 8.
 */
public class Problem001A {
	
	static public int resolve(final int limit) {
		return IntStream.range(0, limit)
			.filter(n -> n % 3 == 0 || n % 5 == 0)
			.sum();
	}
	
	static public void main(String[] args) {
		Instant start = Instant.now();
		System.out.println("Answer: " + resolve(1000));		
		System.out.println("Time: " + Duration.between(start, Instant.now()).toMillis());
	}
	
}
