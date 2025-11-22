package LeetCode2;

public class MinimumMovesToMakeArrayEqual {
    public int minMoves(int[] nums) {
        if(nums.length == 1) return 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int x : nums) min = Math.min(min, x);
        for(int x : nums) ans += x != min ? x-min : 0;
        return ans;
    }
    //1,2,3
    //2,3,3
    //3,4,3
    //4,4,4

    // 1 2 3 4
    // 2 3 4 4
    // 3 4 5 4
    // 4 5 5 5
    // 5 6 6 5
    // 6 7 6 6
    // 7 7 7 7

    // 1 2 3 4
    // 1 2 3 3
    // 1 2 3 2
    // 1 2 2 2
    // 1 2 2 1
    // 1 1 2 1
    // 1 1 1 1

    // 1 2 3 4
    // 1 2 3 3
    // 1 2 3 2
    // 1 2 3 1
    // 1 2 2 1
    // 1 2 1 1
    // 1 1 1 1
}
