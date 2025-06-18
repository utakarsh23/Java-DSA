package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//try again
public class LongestPalindromicString {
    public static void main(String[] args) {
//        System.out.println(subseqList("", "hies"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
//    static String longestPalindrome(String s) {
//        List<String> ss = subseqList("", s);
//        Set<String> st = new HashSet<>();
//        for (String x : ss) {
//            if(!x.equals("") && palindrome(x)) {
//                st.add(x);
//            }
//        }
//        String sor = "";
//        int maxSize = Integer.MIN_VALUE;
//        for (String i : st) {
//            if(i.length() > maxSize) {
//                maxSize = i.length();
//                sor = i;
//            }
//        }
//        return sor;
//    }
//    static ArrayList<String> subseqList(String p, String up) {
//        if(up.isEmpty()) {
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        char ch = up.charAt(0);
//        ArrayList<String> left = subseqList(p+ch, up.substring(1));
//        ArrayList<String> right = subseqList(p, up.substring(1));
//
//        left.addAll(right);
//        return left;
//    }
//    static boolean palindrome(String s) {
//        int i = s.length()/2;
//        int j = 0;
//        while (s.charAt(j) != s.charAt(s.length()-1-j)) {
//            return false;
//        }
//        return true;
//    }
static String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }

    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
        int odd = expandAroundCenter(s, i, i);
        int even = expandAroundCenter(s, i, i + 1);
        int max_len = Math.max(odd, even);

        if (max_len > end - start) {
            start = i - (max_len - 1) / 2;
            end = i + max_len / 2;
        }
    }

    return s.substring(start, end + 1);
}

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
