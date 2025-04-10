package LeetCode;

public class CircularSubarraySum {

    public static void main(String[] args) {

    }
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int gMax = arr[0], gMin = arr[0];
        int currMax = 0, currMin = 0;
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            currMin = Math.min(currMin + arr[i], arr[i]);
            total += arr[i];
            gMax = Math.max(gMax, currMax);
            gMin = Math.min(gMin, currMin);

        }
        return gMax > 0 ? Math.max(gMax, total - gMin) : gMax;
    }
}
