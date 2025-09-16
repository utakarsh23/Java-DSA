package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoPrimesNoInAnArray {
    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[] {31,97561,97561,97561,97561,97561,97561,97561,97561}));
    }
    public static List<Long> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            // Push current number
            stack.add(num);

            // Merge backward while gcd > 1
            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 1);
                int b = stack.get(stack.size() - 2);

                int g = gcd(a, b);
                if (g == 1) break;

                // Merge into LCM and replace last two elements
                long lcm = (long) a * b / g;
                stack.remove(stack.size() - 1);
                stack.set(stack.size() - 1, (int) lcm);
            }
        }
        return stack;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
