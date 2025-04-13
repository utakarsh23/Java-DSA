package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(nonRepeatingChar(s));
    }
    static char nonRepeatingChar(String s) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        ArrayList<Character> li = new ArrayList<>();
        for(char key : map.keySet()) {
            if(map.get(key) == 1) {
                li.add(key);
            }
        }
//        Map<Character, Integer> map1 = new HashMap<>();
//        int i = 0;
//        for(char c : li) {
//            map1.put(c, s.indexOf(li.get(i++)));
//        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < li.size(); i++) {
            if(s.indexOf(li.get(i)) != -1 && s.indexOf(li.get(i)) < min) {
                min = s.indexOf(li.get(i));
            }
        }
        return min == Integer.MAX_VALUE ? '$' : s.charAt(min);
    }
}
