package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FairCandySwap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[] {1, 1}, new int[] {2, 2})));
    }
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sa = 0;
        int sb = 0;
        for(int x : aliceSizes) {
            sa += x;
        }
        for(int x : bobSizes) {
            sb += x;
        }
        int ba = (sb-sa)/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < bobSizes.length; i++) {
            map.put(bobSizes[i], i);
        }

        int bob = 0;
        int alice = 0;
        for (int aliceSize : aliceSizes) {
            int diff = aliceSize + ba;
            if (map.containsKey(diff)) {
                bob = bobSizes[map.get(diff)];
                alice = aliceSize;
                break;
            }
        }
        return new int[] {alice, bob};
    }
}