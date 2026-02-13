package Recursion.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraysDuplicates {
    public static void main(String[] args) {
        int[] adr = {1, 2, 2};
        System.out.println(subseqDUplicatesss(adr));
    }
    static List<List<Integer>> subseqDUplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int x: arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(x);
                if(!outer.contains(internal)) outer.add(internal);
            }
        }
        return outer;
    }
    //Main one
    static List<List<Integer>> subseqDUplicatesss(int[] arr) {
        int start = 0;
        int end = 0;
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int j = 0; j < arr.length; j++) {
            start = 0;
            if(j > 0  && arr[j] == arr[j-1]) {
                start = end+1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for (int i = start; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[j]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
