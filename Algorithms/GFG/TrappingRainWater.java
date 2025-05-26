package GFG;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
        System.out.println();
    }
    static int trap(int[] height) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        int[][] arr = new int[height.length][2];
        for(int i = 0; i < height.length; i++) {
            left = Math.max(left, height[i]);
            right = Math.max(right, height[height.length-1-i]);
            arr[i][0] = left;
            arr[arr.length-1-i][1] = right;
        }
        int total = 0;
        for(int i = 0; i < height.length; i++) {
            total = total + Math.min(arr[i][1], arr[i][0]) - height[i];
        }
        return total;
    }
}
