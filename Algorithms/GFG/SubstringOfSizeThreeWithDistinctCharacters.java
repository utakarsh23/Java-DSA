package GFG;

import java.util.HashSet;
import java.util.Set;

class SubstringOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings1("aababcabc"));
    }
    static int countGoodSubstrings(String s) {
        StringBuilder sb = new StringBuilder(s.substring(0, 3));
        int count = 0;
        for(int i = 3; i <= s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                set.add(sb.charAt(j));
            }
            count = set.size() == 3 ? ++count : count;
            sb.append(s.charAt(i));
            sb = new StringBuilder(sb.substring(1));
        }
        return count;
    }

    static int countGoodSubstrings1(String s) {
        int count = 0;
        for(int i = 0; i < s.length()-2; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i+3; j++) {
                set.add(s.charAt(j));
            }
            count = (set.size() == 3) ? ++count : count;
        }
        return count;
    }
}