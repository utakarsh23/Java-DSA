package LeetCode2;

import java.util.Arrays;

public class CountOfRangeSum {
    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[] {1,2,3,1}, -2, 2));
    }
    static public int countRangeSum1(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = (long)nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+(long)nums[i];
        }
        int c = 0;
        for(int i = 0; i < n; i++) {
            long subEle = i == 0 ? 0 : prefix[i-1];
            for(int j = i; j < n; j++) {
                long x = prefix[j]-subEle;
                if(checkRange1(x, (long)lower, (long)upper)) c++;
            }
        }
        return c;
    }

    private static boolean checkRange1(long x, long l, long r) {
        return  x >= l && x <= r;
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        return checkRange(nums, null, lower, upper);
    }
    private static int checkRange(int[] arr1, int[] arr2, long l, long r) {
        if(arr1.length == 1) {
            long x = arr1[0];
            return x >= l && x <= r ? 1 : 0;
        }

        int[] a1 = Arrays.copyOfRange(arr1, 0, arr1.length/2);
        int[] a2 = Arrays.copyOfRange(arr1, arr1.length/2, arr1.length);

        int l1 = checkRange(a1, a2, l, r);
        int r1 = checkRange(a2, arr2, l, r);
        return l1 + r1;
    }
}
