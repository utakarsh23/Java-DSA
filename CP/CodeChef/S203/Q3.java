package CodeChef.S203;

import java.util.Scanner;

public class Q3 {
    public static void main (String[] args) throws Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        for(int i = 0; i < t; i++) {
            long n = sc.nextInt();
            long ans = Long.MAX_VALUE;

            for (int b = 0; b <= n / 3; b++) {
                long remaining = n - 3 * b;
                if (remaining % 2 == 0) {
                    long a = remaining / 2;
                    long cost = 4 * a + 5 * b;
                    ans = (long)Math.min(ans, cost);
                }
            }

            System.out.println(ans);
        }

    }

    private static void useTwo(int[] arr) {

    }
}
