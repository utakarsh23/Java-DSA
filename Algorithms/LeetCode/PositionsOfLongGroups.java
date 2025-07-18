package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLongGroups {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }
    static public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lis = new ArrayList<>();
        for(int i = 1; i < s.length(); i++) {
            List<Integer> li = new ArrayList<>();
            int j = i-1;
            while(i < s.length() && s.charAt(i-1) == s.charAt(i)) {
                i++;
            }
            if(i - j >= 3) {
                i--;
                li.add(j);
                li.add(i);
                lis.add(li);
            }
        }
        return lis;
    }
}
