package IntroductoryProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IncreasingArray {
    public static void main(String[] args) {
        System.out.println(incArray(new int[] {3, 2, 5, 1, 7}));
    }

    static int incArray(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            while(arr[i-1] > arr[i]) {
                arr[i]++;
                count++;
            }
        }
        return count;
    }
    
}
