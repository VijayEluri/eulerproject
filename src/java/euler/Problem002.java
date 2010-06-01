package euler;

/**
 *
 * @author Pascal
 */
public class Problem002 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;
        int prev = 1;
        int n = 2;
        while (n <= 4000000) {
            if (n%2 == 0) {
                sum += n;
            }
            int tmp = n;
            n = prev + n;
            prev = tmp;
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");        
        System.out.println(sum);
    }
}
