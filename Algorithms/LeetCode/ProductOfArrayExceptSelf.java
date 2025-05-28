package LeetCode;

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
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

    static int[] productExceptSelf1(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
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

    static int[] productExceptSelf2(int[] arr) {
        int[][] ss = new int[arr.length][2];
        int left = 1;
        int right = 1;
        int temp1 = 1;
        int temp2 = 1;
        for (int i = 0; i < arr.length; i++) {
            left *= temp1;
            temp1 = arr[i];
            right *= temp2;
            temp2 = arr[arr.length-1-i];
            ss[i][0] = left;
            ss[arr.length-1-i][1] = right;
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ss[i][0] * ss[i][1];
        }
        return ans;
    }
}