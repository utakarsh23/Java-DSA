package LeetCode2;

import java.util.Arrays;

public class MaxRuntimeOfnComputers {
    public static void main(String[] args) {
        System.out.println(maxRunTime(2, new int[] {3,3,3}));
    }
    static public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        return helper(batteries, n, 0);
    }

    private static long helper(int[] batteries, int n, long sum) {
        if(batteries.length < n) {
            return sum;
        }
        int len = batteries.length;
        int i = len - n;
        int c = 0;
        sum += 1;
        while(i < len) {
            batteries[i] -= 1;
            c += batteries[i] == 0 ? 1 : 0;
            i++;
        }
        Arrays.sort(batteries);
        long nextSum = helper(Arrays.copyOfRange(batteries, c, len), n , sum);
        return nextSum;
    }
}
