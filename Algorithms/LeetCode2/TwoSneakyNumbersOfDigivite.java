package LeetCode2;

public class TwoSneakyNumbersOfDigivite {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int[] arr = new int[101];
        int i = 0;
        for(int x : nums) {
            arr[x]++;
            if(arr[x] == 2) {
                ans[i] = x;
                i++;
            }
            if(i == 2) break;
        }
        return ans;
    }
}
