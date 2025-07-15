package LeetCode;

import java.util.Arrays;

public class SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome1("babab"));
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


    public static String smallestPalindrome1(String s) {
        int n = s.length();
        if(n == 1 || n == 2) return s;
        int m = n/2;
        StringBuilder sb = new StringBuilder();
        int[] farr = new int[26];
        for(int i = 0; i<m; i++){
            farr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i<26; i++){
            if(farr[i] > 0){
                char ch = (char) (i + 'a');
                sb.repeat(ch,farr[i]);
            }
        }
        StringBuilder rev = new StringBuilder(sb).reverse();
        if(n%2 == 1){
            sb.append(s.charAt(m));
        }
        return sb.toString() + rev.toString();
    }
}
