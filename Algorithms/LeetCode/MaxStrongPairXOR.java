package LeetCode;

import java.util.Arrays;

public class MaxStrongPairXOR {
    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[] {5,10,6,8,10}));
    }
    static public int maximumStrongPairXor(int[] nums) {
        //brute force
        // int xor = 0;
        // for(int x : nums) {
        //     for(int y : nums) {
        //         if(Math.abs(x - y) <= Math.min(x, y)) {
        //             xor = Math.max(xor, x ^ y);
        //         }
        //     }
        // }
        // return xor;
        //
        Arrays.sort(nums);
        int j = nums.length-1;
        int i = nums.length-1;
        int max = 0;
        while(i >= 0 && j >= 0) {
            int y = nums[j];
            int x = nums[i];
            if(y - x <= x) {
                int xor = x^y;
                max = Math.max(max, xor);
            } else {
                j--;
                i = j-1;
                continue;
            }
            if(i == 0) {
                j--;
                i = j;
            }
            i--;

        }
        return max;
    }
}
