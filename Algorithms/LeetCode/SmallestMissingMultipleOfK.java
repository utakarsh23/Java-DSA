package LeetCode;

import java.util.HashSet;

class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int i = k;; i += k)
            if (!set.contains(i)) return i;
    }
}