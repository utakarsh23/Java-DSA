package LeetCode2;

public class CountTheNoofSubstringsWithDominantOnes {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("00011"));
    }
    static public int numberOfSubstrings(String s) {
        //0 0 0 1 1
        //1 2 3 3 3
        //2 2 2 2 1

        int len = s.length();
        int[] zero = new int[len];
        int[] one = new int[len];
        zero[0] = s.charAt(0) == '0' ? 1 : 0;
        one[0] = s.charAt(0) == '1' ? 1 : 0;

        for (int i = 1; i < len; i++) {
            zero[i] = zero[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            one[i] = one[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int c = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

                int zeros = zero[j] - (i > 0 ? zero[i - 1] : 0);
                int ones  = one[j] - (i > 0 ? one[i - 1] : 0);

                if (ones >= zeros * zeros) {
                    c++;
                }
            }
        }
        return c;
    }

    public int numberOfSubstrings1(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt0 = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;
            while (j > 0 && cnt0 * cnt0 <= n) {
                int cnt1 = (i - pre[j]) - cnt0;
                if (cnt0 * cnt0 <= cnt1) {
                    res += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return res;
    }
}
