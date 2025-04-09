package GFG;

class maximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
//        System.out.println(maxProduct2(nums));
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8, 9};
        int id = 3;
        for(int i = 0; i < arr.length && arr[i] != id; i++) {
            System.out.println(arr[i]);
        }
    }
    static int maxProduct(int[] nums) {
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
    static int maxProduct1(int[] nums) {
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

    static int maxProduct2(int[] nums) {
        int pre = 1, suff = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(suff == 0) suff = 1;
            if(pre == 0) pre = 1;
            pre = nums[i] * pre;
            suff = nums[n-i-1] * suff;
            max = Math.max(max, Math.max(pre, suff));
        }
        return max;

    }
}