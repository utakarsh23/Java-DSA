package F1400To1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayHalves {
//    public static void main(String[] args) throws Exception {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[2*n];
//            for (int i = 0; i < 2*n; i++) {
//                arr[i] = in.nextInt();
//            }
//            int left = 0;
//            int right = 0;
//            int ans = 0;
//            for (int i = 0; i < 2*n; i++) {
//                if(arr[i] > n && i < n) {
//                    ans += n - i - 1 - left;
//                    left++;
//                }
//                if(arr[i] <= n && i >= n) {
//                    ans += i - n - right;
//                    right++;
//                }
//            }
//            System.out.println(ans + left * right);
//        }
//    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        while(t-- > 0) {
            int n = input.nextInt();
            int[] nums = new int[2*n];
            for (int i = 0; i < 2*n; i++) {
                nums[i] = input.nextInt();
            }
            int i = n-1;
            int j = 2*n-1;
            long ans = 0;
            while(i >= 0 && j >= n) {
                while(i >= 0 && nums[i] <= n) {
                    i--;
                }
                while(j > n-1 && nums[j] > n) {
                    j--;
                }
                ans = i == -1 && j == n-1 ? ans : ans + (j-i);
                j--; i--;
            }
            System.out.println(ans);
        }
        // 1 2 3 4 5 6
        // i = 2, j = 5
        // 1 2 4 3 5 6
        //
        //

    }
}
