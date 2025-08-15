package LcContests.Biweekly.B161;

import java.util.Arrays;

public class absssss {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[] {2, 3, 4}));
    }
    static public long splitArray(int[] nums) {
        int suma = 0;
        int sumb = 0;

        int[] arr = sieve(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if(arr[i] == 1) {
                suma += nums[i];
            } else {
                sumb += nums[i];
            }
        }
        int ans = Math.abs(suma - sumb);
        return ans;
    }
    static int[] sieve(int n) {
        int arr[] = new int[n+1];
        Arrays.fill(arr, 1);
        if(n < 3) {
            return arr;
        }
        arr[0] = arr[1] = 0;
        /// /
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(arr[i] == 1) {
                for(int j = i * i; j <= n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }
}
