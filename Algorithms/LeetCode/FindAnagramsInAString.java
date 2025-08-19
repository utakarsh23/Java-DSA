package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagramsInAString {
    public static void main(String[] args) {

    }

    //ineff
    public List<Integer> findAnagrams(String s, String p) {
        char[] c = p.toCharArray();
        Arrays.sort(c);
        String r = new String(c);
        List<Integer> li = new ArrayList<>();
        if(s.length() < p.length()) return li;
        int k = p.length();
        int i = k;
        while(i <= s.length()) {
            String w = s.substring(i - k, i);
            if(anagram(r, w)) {
                li.add(i-k);
            }
            i++;
        }
        return li;
    }

    static boolean anagram(String c, String t) {
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        return c.equals(new String(tt));
    }

    //m2
    public List<Integer> findAnagrams1(String s, String p) {
        int[] pc = new int[26];
        int[] sc = new int[26];

        for(char c : p.toCharArray()) {
            pc[c-'a']++;
        }
        int k = p.length();
        List<Integer> li = new ArrayList<>();
        if(s.length() < p.length()) return li;
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i)-'a']++;
            if(i >= k) {
                sc[s.charAt(i - k) - 'a']--;
            }

            if(Arrays.equals(pc, sc)) {
                li.add(i-k+1);
            }
        }
        return li;
    }

}
