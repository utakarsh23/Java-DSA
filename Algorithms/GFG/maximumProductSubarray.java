package GFG;

class maximumProductSubarray {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int currMax = maxProduct;
            int currMin = minProduct;

            maxProduct = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            minProduct = Math.min(nums[i], Math.min(nums[i] * currMax, nums[i] * currMin));

            ans = Math.max(maxProduct, minProduct);
        }
        return ans;
    }

    //

    //correct
    public int maxProduct1(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            res = Math.max(res, n);
        }

        int curMax = 1, curMin = 1;

        for (int n : nums) {
            int temp = curMax * n;
            curMax = Math.max(temp, Math.max(curMin * n, n));
            curMin = Math.min(temp, Math.min(curMin * n, n));

            res = Math.max(res, curMax);
        }

        return res;
    }
}