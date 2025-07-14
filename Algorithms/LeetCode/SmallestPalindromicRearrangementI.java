package LeetCode;

import java.util.Arrays;

public class SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("babab"));
    }
    static public String smallestPalindrome(String s) {
        if(s.length() < 2) return s;
        char[] t = s.substring(0, s.length()/2).toCharArray();

        String w = "";
        if(s.length() % 2 != 0) {
            w = String.valueOf(s.charAt(s.length()/2));
        }
        Arrays.sort(t);
        StringBuilder st = new StringBuilder(new String(t)).reverse();

        return new String(t) + w + st;
    }
}
