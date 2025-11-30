package LeetCode2;

import java.util.HashMap;

public class MakeSumDivByP {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[] {1,2,3}, 7));
    }
//    static public int minSubarray(int[] nums, int p) {
//        int n = nums.length;
//        int[] arr = new int[n+1];
//        arr[0] = 0;
//        for(int x = 1; x <= n; x++) {
//            arr[x] = arr[x-1]+nums[x-1];
//        }
//        if(arr[n] % p == 0) return 0;
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i <= n; i++) {
//            int se = arr[i];
//            for(int j = i+1; j < n; j++) {
//                int diff = arr[n] - (arr[j]-se);
//                if(diff%p == 0) min = Math.min(min, j - i);
//            }
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }

    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if (target == 0) {
            return 0;
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int currentSum = 0;
        int minLen = n;

        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            int needed = (currentSum - target + p) % p;

            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            modMap.put(currentSum, i);
        }

        return minLen == n ? -1 : minLen;
    }

}
