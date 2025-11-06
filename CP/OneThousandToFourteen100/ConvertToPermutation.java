package OneThousandToFourteen100;

import java.util.Arrays;
import java.util.Scanner;

class ConvertToPermutation {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            //1 2 4 4 5
            // i = 2,
            // a[i] = 4;
            // if(a[i] > i + 1)
            // 1 2 2 4 5
            // i = 2,
            // a[i] = 2;
            // if(a[i] < i + 1)
            //      ans += (i+1) - a[i];
            //
            int ans = 0;
            for(int i = 0; i < n; i++) {
                if(a[i] > i + 1) {
                    ans = -1;
                    break;
                }
                if(a[i] < i + 1) {
                    ans += (i+1) - a[i];
                }

            }
            System.out.println(ans);
        }
    }
}