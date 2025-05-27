package LeetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(arr));
    }
    //brute force
    static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++) {
                int s = (j-i)*Math.min(height[i], height[j]);
                max = Math.max(s, max);
            }
        }
        return max;
    }


    //optimal
    static int maxArea1(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int max = 0;
        while (left < right) {
            max = Math.max((right-left)*Math.min(arr[left], arr[right]), max);
            if(arr[left] > arr[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
