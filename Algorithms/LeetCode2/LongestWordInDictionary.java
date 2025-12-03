package LeetCode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[] {"w","wo","wor","worl","wortd"}));
    }

    static public String longestWord(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        for(String s : words) {
            set.add(s);
        }
        String ans = "";
        int ml = 0;
        String mainAns = "";
        for(int i = n-1; i >= 0; i--) {
            String ans = "";
            String s = words[i];
            String t = s.substring(0, s.length());
            while(!t.isEmpty()) {
                if(set.contains(t)) {
                    ans = ans.length() <= t.length() ? t : ans;
                    ml = ans.length();
                } else {
                    ans = "";
                }
                t = t.substring(0, t.length()-1);
            }
            mainAns = mainAns.length() <= ans.length() ? ans : mainAns;
        }
        return mainAns;
    }
}
