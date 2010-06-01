/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author Pascal
 */
public class Problem014 {

    public static int collatz(int n) {
        int i = 1;
        long k = n;
        while (k > 1) {
            i++;
            if (k % 2 == 1) {
                k = 3 * k + 1;
            } else {
                k = k / 2;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int max = 0;
        int n = 0;
        for (int i = 1; i < 1000000; i++) {
            int l = collatz(i);
            if (l > max) {
                max = l;
                n = i;
            }
        }
        System.out.println(n + " (" + max + ")");

    }
}
