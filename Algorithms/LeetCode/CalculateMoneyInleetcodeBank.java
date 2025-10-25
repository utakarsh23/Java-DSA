package LeetCode;

public class CalculateMoneyInleetcodeBank {
    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }
    public static int totalMoney(int n) {
        int sum = 0;
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = i+1;
        }
        for(int i = 0; i < n; i++) {
            sum += arr[i % 7];
            arr[i % 7]++;
        }
        return sum;
    }
}
