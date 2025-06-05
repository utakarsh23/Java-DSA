package LeetCode;


class LongestEvenOddSubarraywithThreshhold {
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int maxLen = 0;

        for (int l = 0; l < n; l++) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) {
                continue;
            }

            int r = l;

            while (r < n && nums[r] <= threshold && (r == l || nums[r] % 2 != nums[r - 1] % 2)) {
                r++;
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}