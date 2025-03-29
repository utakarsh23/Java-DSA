package GFG;

import java.util.Arrays;

public class nextPermutations {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void nextPermutation(int[] arr) {
        // code here
        int i = arr.length-2;
        int ind = -1;
        while (i >= 0) {
            if(arr[i] < arr[i+1]){
                ind  = i;
                break;
            }
            i--;
        }
        if(ind == -1) {
            Arrays.sort(arr);
            return;
        }

        int min = Integer.MAX_VALUE;
        int j = arr.length-1;
        int sInd = 0;
        while (j > i) {
            if(arr[j] > arr[i]) {
                int temp = min;
                min = Math.min(min, arr[j]);
                if(min != temp) sInd = j;

            }
            j--;
        }
        swap(arr, i, sInd);
        sortPartially(arr, i+1);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sortPartially(int[] arr, int fromInd) {
        int[] li = Arrays.copyOfRange(arr, fromInd, arr.length);
        int j = 0;
        Arrays.sort(li);
        for (int i = fromInd; i < arr.length; i++) {
            arr[i] = li[j++];
        }
    }
}
