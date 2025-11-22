package LeetCode2;

import java.util.Arrays;

public class MinimumMovesToMakeArrayElementsEqualII {
    public int minMoves2(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        Arrays.sort(nums);
        int m = len/2;
        int tme;
        if(len % 2 == 0) {
            int me = nums[m];
            int bme = nums[m-1];
            if(nums[len-1] - bme > me - nums[0]) tme = me;
            else tme = bme;
        } else {
            tme = nums[m];
        }
        int ans = 0;
        for(int x : nums) {
            ans += Math.abs(x - tme);
        }
        return ans;
    }
    //1,2,3
    // 2 2 3
    // 2 2 2

    // 1 2 9 10
    // 2 2 9 10 - 1
    // 2 2 2 10 - 7
    // 2 2 2 2 - 8

    // 1 2 3 9 10
    // 3 2 3 9 10 - 2
    // 3 3 3 9 10 - 1
    // 3 3 3 3 10 - 6
    // 3 3 3 3 3 - 7

    // 1 2 3 9 10 12
    // 9 2 3 9 10 12 - 8
    // 9 9 3 9 10 12 - 7
    // 9 9 9 9 10 12 - 6
    // 9 9 9 9 9 12 - 1
    // 9 9 9 9 9 9 - 3

    // 1 2 3 9 10 12 18
    // 9 2 3 9 10 12 18 - 8
    // 9 9 3 9 10 12 18 - 7
    // 9 9 9 9 10 12 18 - 6
    // 9 9 9 9 9 12 18 - 1
    // 9 9 9 9 9 9 18 - 3
    // 9 9 9 9 9 9 9 - 9

    // 1 2 3 9 10 12 18 23
    // 10 2 3 9 10 12 18 23 - 9
    // 10 10 3 9 10 12 18 23 - 8
    // 10 10 10 9 10 12 18 23 - 7
    // 10 10 10 10 10 12 18 23 - 1
    // 10 10 10 10 10 10 18 23 - 2
    // 10 10 10 10 10 10 10 23 - 8
    // 10 10 10 10 10 10 10 10 - 13
}
