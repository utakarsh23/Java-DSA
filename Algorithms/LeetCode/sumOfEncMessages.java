package LeetCode;

class sumOfEncMessages {
    public static void main(String[] args) {
        System.out.println(sumOfEncryptedInt(new int[] {10,21,31}));
    }
    static int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            // num = conv(num);
            sum += conv(num);
        }
        return sum;
    }
    static int conv(int num) {
        int c = 0;
        int max = Integer.MIN_VALUE;
        while(num != 0) {
            int rem = num%10;
            max = Math.max(max, rem);
            num /= 10;
            c++;
        }
        int temp = 0;
        for(int i = 0; i < c; i++) {
            temp = temp*10 + max;
        }
        return max;
    }
}