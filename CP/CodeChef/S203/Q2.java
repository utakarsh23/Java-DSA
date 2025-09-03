package CodeChef.S203;

import java.util.Scanner;

public class Q2 {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        for(int i = 0; i < t; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long l = 2 * y + x;
            if(2 * y + x + 12 >= 50 && l > 38 && l <= 50) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
