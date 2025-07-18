package LeetCode;

public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
        String s = "asdfghjkl";
        String t = new String("asdfghjkl");
    }

    static boolean isPowerOfFour(int n) {
        long t = n;
        for(int i = 0; i <= 32; i++) {
            long s = (long)Math.pow(4, i);
            if(s == t) return true;
        }
        return false;
    }
}
