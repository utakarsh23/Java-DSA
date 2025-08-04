package LeetCode;

public class TrionicArrayI {
    public static void main(String[] args) {
        System.out.println(isTrionic(new int[]{2, 1, 3}));
    }
    static public boolean isTrionic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        boolean inc1 = false;
        for(int i = 1; i < nums.length; i++) {
            if(!inc && nums[i] > nums[i-1]) {
                while (i < nums.length && nums[i] > nums[i-1]) {
                    i++;
                }
                i--;
                inc = true;
            } else if(!dec && inc && nums[i] < nums[i-1]) {
                while (i < nums.length && nums[i] < nums[i-1]) {
                    i++;
                }
                i--;
                dec = true;
            } else if(!inc1 && inc && dec && nums[i] > nums[i-1]) {
                while (i < nums.length && nums[i] > nums[i-1]) {
                    i++;
                }
                i--;
                inc1 = true;
            }  else {
                return false;
            }
        }
        return (inc && dec && inc1);
    }
}
