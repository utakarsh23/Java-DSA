package LcContests.Biweekly.B161.B162;

import java.util.Arrays;

import static java.lang.Math.abs;

class NoOfPerfectPairs {
    public static void main(String[] args) {
        System.out.println(perfectPairs(new int[] {-3, -2, -1, 4}));
    }
    public static long perfectPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
           for(int j = i+1; j < nums.length; j++) {
               int x = Math.abs(nums[i]-nums[j]);
               int y = Math.abs(nums[i]+nums[j]);
               int r = Math.max(x, y);
               int s = Math.min(x, y);
               int u = Math.min(Math.abs(nums[i]), Math.abs(nums[j]));
               int t = Math.max(Math.abs(nums[i]), Math.abs(nums[j]));
                if(s <= u && r >= t) {
                    count++;
                }
            } 
        }
        return count;
    }
        public long perfectPairs1(int[] nums) {
            long count = 0;
            int n = nums.length;

            int[] abs = new int[n];
            for (int i = 0; i < n; i++) {
                abs[i] = Math.abs(nums[i]);
            }

            Arrays.sort(abs);

            int left = 0;
            for (int right = 0; right < n; right++) {
                while (abs[left] * 2 < abs[right]) {
                    left++;
                }

                count += (right - left);
            }

            return count;
        }
}