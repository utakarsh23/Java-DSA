package LeetCode2;

public class MinimumNumberOfIncrementsOnSubarrayToFormATargetArray {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    static public int minNumberOperations(int[] target) {
        int len = target.length;
        int count = 0;
        int c = 1;
        int i = 0;
        int s = 0;
        while (true) {
            c = 0;
            s = 0;
            while (i < len && target[i] != 0) {
                target[i]--;
                i++;
                c = 2;
            }
            while (i < len && target[i] == 0) {
                i++;
                s = 1;
            }
            if (c == 2) {
                count++;
            }
            if (i == len && c != 0) i = 0;
            if (i == len && s == 1) break;
        }
        return count;
    }
    static public int minNumberOperations1(int[] target) {
        int n = target.length;
        int ans = target[0];
            for(
        int i = 1; i<n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
