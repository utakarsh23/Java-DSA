package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuddlyStrings {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
    }
    static boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if (s.equals(goal)) {
            // Check for duplicate characters
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                if (++freq[c - 'a'] > 1) return true;
            }
            return false;
        }

        Map<Integer, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(i, s.charAt(i));
        }
        int[] arr = new int[2];
        int j = 0;
        for(int i = 0; i < goal.length(); i++) {
            if(map.get(i) != goal.charAt(i)) {
                if (j >= 2) return false;
                arr[j++] = i;
            }
        }
        if(arr[0] == arr[1]) return false;
        String t = swap(s, arr[0], arr[1]);
        return t.equals(goal);
    }
    static String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        char temp = s.charAt(a);
        sb.setCharAt(a, s.charAt(b));
        sb.setCharAt(b, temp);
        return sb.toString();
    }

}
