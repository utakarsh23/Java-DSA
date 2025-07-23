package LeetCode;

import java.util.Arrays;

public class FindTheLoserOfCircularGame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(5, 2)));
    }
    static public int[] circularGameLosers(int n, int k) {
        boolean[] arr = new boolean[n];
        int i = 0;
        int j = 1;
        while(!arr[i]) {
            arr[i] = true;
            i = i + (j * k);
            i = i %n;
            j++;
        }
        int[] arrs = new int[n];
        i = 0;
        j = 0;
        for (int l = 0; l < arr.length; l++) {
            if(!arr[l]) {
                arrs[j++] = l+1;
            }
        }
        return Arrays.copyOfRange(arrs, 0, j);
    }
}
