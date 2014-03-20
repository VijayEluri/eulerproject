package euler;

import java.time.Duration;
import java.time.Instant;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Same as Problem002, but using Java 8.
 */
public class Problem002A {

    /**
     * Skip the first few elements of Fibonacci and start at 2.
     */
    static class FibSupplier implements LongSupplier {
        long prev = 1;
        long fib = 2;

        @Override
        public long getAsLong() {
            long tmp = fib;
            fib = prev + fib;
            prev = tmp;
            return prev;
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now(); 
        
        // There is no takeWhile() method with streams, so I have
        // to hard-code a limit that goes beyond 4000000 and
        // use a filter to only sum the fib numbers lower than
        // 4000000.
        long sum = LongStream.generate(new FibSupplier())
            .limit(40)
            .filter(n -> n > 0 && n < 4000000 && n % 2 == 0)            
            .sum();
        
        System.out.println(Duration.between(start, Instant.now()).toMillis() + " ms");        
        System.out.println(sum);
    }
}
