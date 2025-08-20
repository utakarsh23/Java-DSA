package OneThousandToFourteen100;

import java.util.Arrays;
import java.util.Scanner;

public class FOur {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        //single n
        while(t-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            int a1 = input.nextInt();
            int temp = a1;
            for (int i = 1; i < n; i++) {
                int ai = input.nextInt();
                arr[(i-2)%n] = (a1 + ai)%2;
                a1 = ai;
            }

        }

    }
}
