package F1400To1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayHalves {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[2*n];
            for (int i = 0; i < 2*n; i++) {
                arr[i] = in.nextInt();
            }
            int left = 0;
            int right = 0;
            int ans = 0;
            for (int i = 0; i < 2*n; i++) {
                if(arr[i] > n && i < n) {
                    ans += n - i - 1 - left;
                    left++;
                }
                if(arr[i] <= n && i >= n) {
                    ans += i - n - right;
                    right++;
                }
            }
            System.out.println(ans + left * right);
        }
    }
}
