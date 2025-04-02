package GFG;

import java.util.Arrays;

public class nextPermutations {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 6};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    //works but not the optimalest approach
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


    //m2
    public static void nextPermutation1(int[] arr) {
        int i = arr.length-2;
        while (i > -1 && arr[i] >= arr[i+1]) {
            i--;
        }
        if(i == -1) {
            reverse(arr, 0, arr.length-1);
            return;
        }
        int j = arr.length-1;
        while (arr[i] > arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i+1, arr.length-1);
    }

    public static void reverse(int[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a++, b--);
        }
    }
}
