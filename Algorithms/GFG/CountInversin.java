package GFG;

import java.util.Arrays;

class CountInversin {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // int c = 0;
        // for(int i = 0; i < arr.length; i++) {
        //     for(int j = i; j < arr.length; j++) {
        //         if(arr[i] > arr[j]) {
        //             c++;
        //         }
        //     }
        // }
        // return c;
        return mergeSort(arr, 0, arr.length-1);
        
    }
    static int mergeSort(int[] arr, int left, int right) {
        int mid, invCount = 0;
        if(left < right) {
            mid = (left + right)/2;
            invCount += mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid+1, right);
            
            invCount += merge(arr, left, mid, right);
        }
        return invCount;
    }
    static int merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, end+1);
        int i = 0;
        int j = 0; 
        int k = start;
        int invCount = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                invCount += (left.length-i);
            }
        }
        while(i < left.length) {
            arr[k++] = left[i++];
        }
        while(j < right.length) {
            arr[k++] = right[j++];
        }
        return invCount;
    }
}