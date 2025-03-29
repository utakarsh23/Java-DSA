package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

class relativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray1(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
    }
    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[arr1.length];
        int i = 0;
        int k = 0;
        while(i < arr1.length) {
            int j = 0;            
            while(i < arr2.length && j < arr1.length) {
                if(arr1[j] == arr2[i]) {
                    list.add(arr1[j]);
                }
                j++;
            }
            i++;
        }
        for (int j = 0; j < arr1.length; j++) {
            if(!list.contains(arr1[j])) {
                list.add(arr1[j]);
            }
        }
        for (int j = 0; j < arr1.length; j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }

    //
    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int length = 0;
        for(int i=0;i<arr1.length;i++){
            length = Math.max(length,arr1[i]);
        }
        int[] count = new int[length+1];
        for(int i=0;i<arr1.length;i++){
            count[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index=0;
        for(int i=0;i<arr2.length;i++){
            while(count[arr2[i]]>0){
                ans[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                ans[index] = i;
                index++;
                count[i]--;
            }
        }
        return ans;
    }
}