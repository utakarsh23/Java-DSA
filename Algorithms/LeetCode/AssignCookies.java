package LeetCode;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {

    }
    static public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int c = 0;
        while(i < g.length && j < s.length) {
            if(g[i] <= s[j]) {
                j++;
                c++;
                i++;
            } else {
                j++;
            }

        }
        return c;
    }
}
