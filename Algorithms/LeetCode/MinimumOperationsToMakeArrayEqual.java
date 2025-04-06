package LeetCode;

class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(minOperations(n));
    }
    static int minOperations(int n) {
        return n * n / 4;
    }
}