package LeetCode;

public class maxAvgSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3,7,9,12}, 4));
    }

    //m1
    static double findMaxAverage(int[] arr, int k) {
        double max = Integer.MIN_VALUE;
        double sum = 0;
        int i = 0;
        for(i = 0; i < k; i++) {
            sum += arr[i];
        }
        int l = Math.min(i + k, arr.length);
        max = Math.max(sum/k, max);
        for(int j = 1; j < arr.length-k+1; j++, l++) {
            sum += arr[j + k - 1];
            sum -= arr[j-1];
            max = Math.max((sum)/k, max);
        }
        return max;
    }

    //m2
    public double findMaxAverage1(int[] arr, int k) {
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        double max = sum;

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        return max / k;
    }
}
