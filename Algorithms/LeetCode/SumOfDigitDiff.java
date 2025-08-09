package LeetCode;

class SumOfDigitDiff {
    public static void main(String[] args) {
        System.out.println(sumDigitDifferences(new int[] {13, 23, 12}));
    }
    public static long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int len = Integer.toString(nums[0]).length();
        int[][] digCount = new int[10][len]; 
        
        long ans = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            String num = Integer.toString(nums[i]);
            for (int pos = 0; pos < num.length(); pos++)
            {
                int dig = num.charAt(pos) - '0';
                int total = n - i - 1; 
                int equal = digCount[dig][pos];  
                int notEqual = total - equal;
                
                ans = ans + (long)notEqual;
                digCount[dig][pos]++;                
            }
        }
        return ans;
    }
}