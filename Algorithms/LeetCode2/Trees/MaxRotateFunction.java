package LeetCode2.Trees;

public class MaxRotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[] {4, 3, 2, 6}));
    }
    static public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sumFirst = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            sumFirst += i * nums[i];
        }
        int max = sumFirst;
        for(int i = 1; i < n; i++){
            sumFirst += sum - ( n * nums[n-i]);
            max = Math.max(sumFirst, max);
        }
        return max;
    }
}
