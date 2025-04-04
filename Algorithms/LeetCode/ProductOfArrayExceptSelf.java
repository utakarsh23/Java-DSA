package LeetCode;

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    static int[] productExceptSelf(int[] nums) {
        int k = 0;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int mul = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i != j){
                    mul = mul * nums[j];
                }
            }
        arr[k++] = mul;
        }
        return arr;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1;
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }
}