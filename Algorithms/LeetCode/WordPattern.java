package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {

    }
    static public boolean wordPattern(String pattern, String s) {

        String[] t = s.split("\\s+");
        if(pattern.length() != t.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        for(char c : pattern.toCharArray()) {
            map.put(c, t[i++]);
        }
        Set<String> set = new HashSet<>(map.values());
        if(set.size() != map.size()) {
            return false;
        }
        for(i = 0; i < pattern.length(); i++) {
            if(!map.get(pattern.charAt(i)).equals(t[i])) {
                return false;
            }
        }
        return true;
    }
}
