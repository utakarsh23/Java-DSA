package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {

    }
    static public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) <= 0) return false;
            System.out.println("huhh");
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        return true;
    }
}
