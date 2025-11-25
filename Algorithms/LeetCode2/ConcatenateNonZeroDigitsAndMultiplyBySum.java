package LeetCode2;

public class ConcatenateNonZeroDigitsAndMultiplyBySum {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        int r = 1;
        while(n > 0) {
            int rem = n%10;
            sum += rem;
            x = rem != 0 ? x + rem*r : x + rem;
            r = rem != 0 ? r * 10 : r;
            n/= 10;
        }
        return sum * x;
    }
}
