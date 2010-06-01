package euler;

public class Problem009 {

    static public int resolve(final int answer) {
        for (int a = 1; a < answer; a++) {
            for (int b = a + 1; b < answer; b++) {
                for (int c = b + 1; c < answer; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.println(String.format("triplet %d %d %d", a, b, c));
                        if (a + b + c == answer) {
                            return a * b * c;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Answer: " + resolve(1000));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}
