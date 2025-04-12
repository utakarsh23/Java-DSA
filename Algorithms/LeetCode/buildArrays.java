package LeetCode;

import java.util.Arrays;

class buildArrays {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        System.out.println(Arrays.toString((runningSum(arr))));
    }
    //https://leetcode.com/problems/build-array-from-permutation/description/
    static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

//    https://leetcode.com/problems/running-sum-of-1d-array/description/
    static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+ nums[i-1];
        }
        return nums;
    }
}