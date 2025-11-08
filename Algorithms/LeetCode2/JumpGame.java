package LeetCode2;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,3,1,1,4}));
    }
    static public boolean canJump1(int[] nums) {
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

    //2,3,1,1,4
    /*
     i = 0, max = 0, 0 > - : false, max = 3
     */

    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;  // start from the end
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;  // we can reach the goal from here, move goal backward
            }
        }
        return goal == 0;
    }
    /*
     2,3,1,1,4.         ||      3,2,1,0,4
     j = 4, i = 3,
     j - i > nums[i] ? j--; i--;

     j - i > nums[i] ? j--; i--; | 4 - 3 > 0 ? j = 3, i = 2;
     j - i > nums[i] ? j--; i--; | 3 - 2 > 1 ? j = 2, i = 1;
     */

}
