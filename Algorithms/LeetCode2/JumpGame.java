package LeetCode2;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,3,1,1,4}));
    }
    static public boolean canJump(int[] nums) {
        int len = nums.length-1;
        int max = 0;
        int i = 0;
        while(i <= len) {
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
            if(max >= len) return true;
            i++;
        }
        return max >= len;
    }
}
