package LeetCode;


public class SuperPalindromes {
    public static void main(String[] args) {
        System.out.println(superpalindromesInRange("53000", "20000000"));
    }
    public static int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int ans = 0;

        for (int k = 1; k < 100000; k++) {
            String s = Integer.toString(k);
            String rs = new StringBuilder(s).reverse().toString();


            long oddRoot = Long.parseLong(s + rs.substring(1));
            long oddSquare = oddRoot * oddRoot;
            if (oddSquare >= L && oddSquare <= R && isPalindrome(oddSquare)) {
                ans++;
            }


            long evenRoot = Long.parseLong(s + rs);
            long evenSquare = evenRoot * evenRoot;
            if (evenSquare >= L && evenSquare <= R && isPalindrome(evenSquare)) {
                ans++;
            }
        }

        return ans;
    }

    private static boolean isPalindrome(long x) {
        String s = Long.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
