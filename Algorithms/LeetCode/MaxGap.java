package LeetCode;

import java.util.Arrays;

public class MaxGap {
    public static void main(String[] args) {

    }
    static int maxGap(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] > max)
                max = Math.max(max, nums[i] - nums[i-1]);
        }
        return max;
    }
}
