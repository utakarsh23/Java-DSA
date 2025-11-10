package F1400To1500;

import java.util.Scanner;

public class PlushleAndMinunOnArray {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        while(t-- > 0) {
            int n = input.nextInt();
            long[] arr = new long[n];
            int i = 0;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            int j = 0;
            for (int k = 0; k < n; k++) {
                arr[k] = Math.abs(input.nextLong());
                if(k % 2 == 0 && arr[k] <= min) {
                    min = arr[k];
                    i = k;
                } else if(k % 2 != 0 && arr[k] >= max) {
                    max = arr[k];
                    j = k;
                }
            }
            // 3 -2 -1 0 1 2 3
            // 3 - 2 + 1 - 0 + 1 - 2 + 3
            // 0   1   2   3   4   5   6
            if(arr[j] > arr[i]) {
                long temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            long ans = 0;
            for (int k = 0; k < n; k++) {
                ans = k % 2 == 0 ? ans + arr[k] : ans - arr[k];
            }
            System.out.println(ans);
        }

    }
}
