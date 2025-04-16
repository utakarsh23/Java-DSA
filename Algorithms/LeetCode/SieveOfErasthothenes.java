package LeetCode;

import java.util.Arrays;

public class SieveOfErasthothenes {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(countPrimes(n));
    }
    static int countPrimes(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(arr[i] == 1) {
                for (int j = i*i; j <= n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(arr[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
