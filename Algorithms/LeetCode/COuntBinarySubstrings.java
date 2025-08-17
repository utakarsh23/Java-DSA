package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class COuntBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00100"));
    }
    static public int countBinarySubstrings(String s) {
        List<int[]> li = new ArrayList<>();
        char c = s.charAt(0);

        for (int i = 1; i <= s.length(); i++) {
            int j = i-1;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
            }
            li.add(new int[] {c-48, i-j});
            c = i < s.length() ? s.charAt(i) : s.charAt(i-1);
        }

        int ans = 0;
        int[] arr = li.getFirst();
        for(int i = 1; i < li.size(); i++) {
            ans += Math.min(arr[1], li.get(i)[1]);
            arr = li.get(i);
        }
        return ans;
    }

    //m2
    public int countBinarySubstrings1(String s) {

    }
}
