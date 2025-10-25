package LeetCode;

import java.util.Arrays;

public class NextGreaterNumericallyBalencdNumber {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
    }
    static public int nextBeautifulNumber(int n) {
        //1000000
        //999999
        int[] arr = new int[9];
//        Arrays.fill(null);
        int i = 0;
        for(char c : String.valueOf(n).toCharArray()) {
            arr[i++] = (c-'0');
        }
        int[] ii = new int[] {i};
        return helper(arr, ii);
    }
    static int helper(int[] arr, int[] i) {
        while(true) {
            int[] a = new int[9];
            for (int j = 0; j < a.length; j++) {
                a[arr[j]] = arr[j];
            }
            int j = 0;
            for (j = 0; j < i[0]; j++) {
                if(a[arr[j]] != j) {
                    break;
                }
            }
            if(j == i[0]) {
                break;
            }

            if(i[0] == 9) i[0]++;
        }

        int ans = 0;
        for (int k : arr) {
            ans = ans * 10 + k;
        }
        return ans;
    }

    public static int nextBeautifulNumber1(int n) {
        n++;
        while (!isBalanced(n)) {
            n++;
        }
        return n;
    }

    private static boolean isBalanced(int num) {
        int[] freq = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        for (char c : digits) {
            freq[c - '0']++;
        }

        for (char c : digits) {
            int d = c - '0';
            if (freq[d] != d) return false;
        }

        return true;
    }

}
