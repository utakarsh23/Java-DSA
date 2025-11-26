package LeetCode2;

public class ArithematicSlices {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }

    static public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n-1];
        for(int i = 1; i < n; i++) {
            arr[i-1] = nums[i]-nums[i-1];
        }
        int c = 0;
        int i = 0;
        n = arr.length;
        while(i < n) {
            int x = arr[i];
            int j = i+1;
            while(j < n && arr[j] == x) {
                j++;
            }
            int r = j - i + 1;
            c += r * (r + 1)/2 - (r * 2 - 1);
            i = j;
        }
        return c;

    }
}
