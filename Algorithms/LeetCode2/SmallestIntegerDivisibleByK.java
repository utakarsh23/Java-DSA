package LeetCode2;

public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        if(k%2 == 0 || k%5 == 0) return -1;
        long t = 0;
        int i = 0;
        for(i = 1; i <= k; i++) {
            t = (t*10 + 1)%k;
            if(t == 0) return i;
        }
        return -1;
    }
}
