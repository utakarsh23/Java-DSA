package LcContests.Biweekly.B161;

public class popcountDepth {
    public static void main(String[] args) {
        System.out.println(popcountDepth(4, 1));
    }
    static public long popcountDepth(long n, int k) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(popcount(i, 0) == k) {
                count++;
            }
        }
        return count;
    }
    static int popcount(long x, int a) {
//        long bin = Long.parseLong(Long.toBinaryString(x));
//        if(bin == 1) {
//            return a;
//        }
//        int ans = 0;
//        while(bin > 0) {
//            if(bin % 10 == 1) {
//                ans++;
//            }
//            bin /= 10;
//        }
//        return popcount(ans, ++a);
//        int ans = Long.bitCount(x);
//        if(ans == 1) return a+1;
//        return popcount(ans, ++a);
        if(x == 1) return a+1;

        long ans = 0;
        while(x > 0) {
            ans += (x & 1);
            x >>= 1;
        }
        return popcount(ans, ++a);
    }
}
