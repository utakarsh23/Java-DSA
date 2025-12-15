package LeetCode2;

public class NumberofSmoothDescentPeriodsofaStock {
    public long getDescentPeriods(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int j = i+1;
            while(j < n && nums[j]+1 == nums[j-1]) j++;
            ans += sumFunc(j - i);
            i = j;
        }
        return ans;
    }

    private long sumFunc(long n) {
        return (n*(n+1))/2;
    }


    // 3 2 1 4
    // 3, 2, 1, 4
    // 3 2 1 -> 6
    // 3 2 1 0 -> 10
    // 4 3 2 1 0 -> 15
    // 5 4 3 2 1 0 -> 21 | 6, 5, 4, 3, 2, 1

    //n(n+1)/2;
    //

    // 3, 2, 1,  4, 3,  5,  3, 2
    // _  _  _ | _  _ | _ | _  _
    // 6      3     1     3

    //
}
