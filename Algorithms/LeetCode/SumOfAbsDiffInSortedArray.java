package LeetCode;

import java.util.Arrays;

class SumOfAbsDiffInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2, 3, 5})));
    }
    static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];

        for(int i = 1; i< nums.length; i++){
            arr[i] = arr[i-1] + nums[i];
        }
        int res[]=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            int left=0;
            if(i>=1)
            {
                left=arr[i-1];
                left=Math.abs(left-(nums[i]*i));
            }
            int right=(arr[nums.length-1]-arr[i])-(nums[i]*(nums.length-(i+1)));
            res[i]=right+left;
        }
        return res;

        
    }
}