package LeetCode2;

public class NumberofSubstringsWithOnlyOnes {
    public int numSub(String s) {
        //1 1 1, 1 1
        // 3 * 2 + 2 * 1
        // 3 - 1
        // 2 - 2
        // 1 - 3
        // 3 * (3 + 1)/2 = 3 * 2
        // 1 1 1 1
        // 4 - 1
        // 3 - 2
        // 2 - 3
        // 1 - 4
        // 4 * (4 + 1)/2 = 4 * 2.5
        // 1 1 1 1 1
        // 5 - 1
        // 4 - 2
        // 3 - 3
        // 2 - 4
        // 1 - 5
        // 5 * (5 + 1)/2 = 5 * 3
        // 1 1 1 1 1 1
        // 6 - 1
        // 5 - 2
        // 4 - 3
        // 3 - 4
        // 2 - 5
        // 1 - 6
        // 6 * (6 + 1)/2 = 6 * 6.5

        //
        int l = 0;
        int r = 0;
        int n = s.length();
        long ans = 0;
        while(l < n && r < n) {
            if(s.charAt(l) == '0') {
                l++;
                r++;
                continue;
            }
            l = r;
            while(r < n && s.charAt(r) == '1') {
                r++;
            }
            int x = r - l;
            double t = x * (double)(x+1)/2;
            ans += (long)t;
            l = r;
        }
        int MOD = 1_000_000_007;
        int sum = (int) (ans % MOD);
        return sum;
    }
}
