package LeetCode;

import java.util.Arrays;

public class smallestMissingPositive {

    public static void main(String[] args) {
        int[] arr = {-8, -1, -4, 1, 2, 4, 3, 5, 6, 7, 8, -3};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr) {
        // Your code here
        int[] nums = new int[10000000];
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                nums[arr[i]-1] = arr[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
