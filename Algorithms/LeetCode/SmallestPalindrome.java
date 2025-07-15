package LeetCode;

public class SmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
    static String abs(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = s.length()-1;
        while (i <= j) {
            if(sb.charAt(i) == sb.charAt(j)) {
                i++; j--;
            } else {
                sb.insert(i, sb.charAt(j));
                i++;
            }
        }
        return sb.toString();
    }

    public static String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s; // The string is already a palindrome
        }
        String sub = s.substring(i);
        String remainRev = new StringBuilder(sub).reverse().toString();
        return remainRev + shortestPalindrome(s.substring(0, i)) + sub;
    }
}
