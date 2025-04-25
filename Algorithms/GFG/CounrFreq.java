package GFG;

import java.util.Arrays;

public class CounrFreq {
    public static void main(String[] args) {
        System.out.println(countFreq(new int[] {1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5}, 4));
    }
    static int countFreq(int[] arr, int target) {
        // code here
        int s = Arrays.binarySearch(arr, target);
        if(s == -arr.length-1) return 0;
        int c = 0;
        int i = s;
        while(i >= 0 && arr[i] == target) {
            i--;
            c++;
        }
        i = s+1;
        while(i < arr.length && arr[i] == target) {
            i++;
            c++;
        }
        return c;
    }
}
