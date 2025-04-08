package LeetCode;

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
}