package LeetCode;

public class findGCDoArray {
    public static void main(String[] args) {
        System.out.println();
    }
    static int findGCD(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int x : nums){
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            return gcd(min, max);
        }


    static int gcd(int a, int b) {
            if(a == 0) {
                return b;
            }
            return gcd(b%a, a);
        }
}
