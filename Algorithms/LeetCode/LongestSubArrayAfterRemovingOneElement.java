package LeetCode;

public class LongestSubArrayAfterRemovingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray1(new int[] {1,1,1}));
    }

    static public int longestSubarray(int[] nums) {
        int max = 0;
        int curr = 0;
        int prev = 0;
        int len = nums.length;
        int i = 0;
        while (i < len) {
//            prev = curr;
            while (i < len && nums[i] == 0) i++;
            int c = 0;
            while (i < len && nums[i] == 1) {
                c++;
                i++;
            }
            int temp = c;
            i++;
//            c = 0;
//            while (i < len && nums[i] == 0) {
//                i++;
//                c++;
//            }
//            if(c > 1) {
//
//            }
            c = 0;
            while (i < len && nums[i] == 1) {
                c++;
                i++;
            }
            curr = prev;
            prev = temp;
            max = Math.max(max, prev + curr);
        }
        return max;
    }


    static public int longestSubarray1(int[] nums) {
        int max = 0;
        int curr = 0;
        int prev = 0;
        int len = nums.length;
        int i = 0;
        int zc = 0;
        while (i < len) {
            prev = curr;
            while (i < len && nums[i] == 0) {
                i++;
                zc++;
                prev = 0;
            }
            int c = 0;
            while (i < len && nums[i] == 1) {
                c++;
                i++;
            }
            curr = c;
            max = Math.max(max, prev + curr);
        }
        return zc == 0 ? max - 1 : max;
    }
}
