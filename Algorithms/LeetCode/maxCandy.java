package LeetCode;

import java.util.HashSet;
import java.util.Set;

class maxCandy {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int x : candyType) {
            set.add(x);
        }
    return Math.min(set.size(), candyType.length / 2);
    }
}