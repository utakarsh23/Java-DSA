package LeetCode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UniqueLengthThreePalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            map.put(s.charAt(i), i);
        }
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) - i >= 2) {
                Set<Character> set = new HashSet<>();
                for(int j = i+1; j < map.get(s.charAt(i)); j++) {
                    set.add(s.charAt(j));
                }
                count+=set.size();
                map.remove(s.charAt(i));
            }
            
        }
        return count;
    }

    //aabca
    // a -> 4
    // b -> 2
    // c -> 3
    // i = 0; ai = a 
    // 4 - 0 = 4 >= 2; c = 1;
    // i = 1; ai = a 
    // 4 - 1 = 3 >= 2; c = 2;
    // i = 2; ai = b -> nil
    // i = 3; ai = c 
    // 4 - 1 = 3 >= 2; c = 2;



    //"bbcbaba"
    // b -> 5
    // c -> 2
    // a -> 6
    // i = 0, ai = b

    //bbaabb
    // b -> 5
    // a -> 3
    // i = 0, ai = b
    // 5 - 0 >= 2; c = 4
    // 

    //aabca
    // a -> 4
    // b -> 2
    // c -> 3
    // i = 0, ai = a
    // 4-0 >= 2 : 
    // a, b, c


}