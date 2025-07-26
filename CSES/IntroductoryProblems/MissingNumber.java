package IntroductoryProblems;

import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{2, 3, 1, 4, 5}));
    }


    static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1) {
                return j+1;
            }
        }
        return arr.length+1;
    }

    
}
