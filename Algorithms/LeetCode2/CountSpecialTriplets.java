package LeetCode2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSpecialTriplets {
    public static void main(String[] args) {
        int x = new CountSpecialTriplets().specialTriplets1(new int[] {0,1,0,0});;
        System.out.println(x);
    }

    // 8  4  4  2  8  4  4  4
    //
   
    
    // m1 starts, brute force at it's peak O(n^2)
    static class mapCount {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        public mapCount() {
        }
        public void putInMapCount(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int j = arr[i];
                right.put(j, right.getOrDefault(j, 0) + 1);
            }
        }
        public mapCount(mapCount mp, int curr, int leftVal) {
            Map<Integer, Integer> left1 = new HashMap<>(mp.left);
            left.putAll(left1);
            left.put(leftVal, left.getOrDefault(leftVal, 0) + 1);
            Map<Integer, Integer> right1 = new HashMap<>(mp.right);
            right1.put(curr, mp.right.get(curr) - 1);
            right.putAll(right1);
        }

        public int compute(int val) {
            int doubleValue = val * 2;
            return left.getOrDefault(doubleValue, 0) * right.getOrDefault(doubleValue, 0);
        }

    }



    public int specialTriplets(int[] nums) {
        int n = nums.length;
        mapCount[] mc = new mapCount[n];
        mc[0] = new mapCount();
        mc[0].putInMapCount(nums);
        int temp = nums[0];
        for (int i = 1; i < n; i++) {
            mc[i] = new mapCount(mc[i-1], nums[i], temp);
            temp = nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += mc[i].compute(nums[i]);
        }
        return ans;
    }


    // 8     4          2        8          4
    // -    8 - 1     8 - 1    8 - 1       -
    //      -----     4 - 1    4 - 1
    //      2 - 1     -----    2 - 1
    //      8 - 1     8 - 1    -----
    //      4 - 1     4 - 1    4 - 1

    //8 - 1 8 - 1     8 - 1    8 - 0      4 - 0
    //4 - 2 4 - 1     4 - 1    4 - 1
    //2 - 1 2 - 1     2 - 0
    // --------------------------------
    // n.   8 - 1     8 - 1    8 - 1      8 - 2
    //                4 - 1    4 - 1      4 - 1
    //                         2 - 1      2 - 1
    //



    //m2 O(n)

    public int specialTriplets1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int x : nums)
            right.put(x, right.getOrDefault(x, 0) + 1);

        long ans = 0;
        int cv = nums[0];

        right.put(nums[0], right.getOrDefault(nums[0], 0) - 1);
        int mod = 1_000_000_007;

        for (int i = 1; i < n; i++) {
            left.put(cv, left.getOrDefault(cv, 0) + 1);
            right.put(nums[i], right.getOrDefault(nums[i], 0) - 1);
            cv = nums[i];
            int doubleValue = cv * 2;
            ans = (ans +
                    (long)left.getOrDefault(doubleValue, 0) *
                            right.getOrDefault(doubleValue, 0)
            ) % mod;
        }
        return (int)ans;//
    }


}
