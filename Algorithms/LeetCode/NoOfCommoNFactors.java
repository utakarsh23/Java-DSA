package LeetCode;

import java.util.Arrays;

class NoOfCommoNFactors {
    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
    }
    static int commonFactors(int a, int b) {
        int s = 0;
        if(a > b) {
            s = a;
        } else {
            s = b;
        }
        int[] arr = new int[s];
        Arrays.fill(arr, 1);
        for(int i = 2; i < s; i++) {
            if(a%i == 0) {
                for(int j = i*i; j < s; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        return 5;
    }
}