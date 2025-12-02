package LeetCode2;

public class CountOfRangeSum {
    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[] {-2, 5, -1}, -2, 2));
    }
    static public int countRangeSum(int[] nums, int lower, int upper) {
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
                if(checkRange(x, (long)lower, (long)upper)) c++;
            }
        }
        return c;
    }

    private static boolean checkRange(long x, long l, long r) {
        return  x >= l && x <= r;
    }
}
