package Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 5};
        int[] proArr = new int[4];
        System.out.println(subs(proArr, ints));
    }


    static List<String> subs(int[] proArr, int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if(arr.length == 0) {
            result.add(Arrays.toString(proArr));
            return result;
        }
        int first = arr[0];
        int[] rest = Arrays.copyOfRange(arr, 1, arr.length);
        int[] pArr = Arrays.copyOf(proArr, proArr.length+1);

        pArr[proArr.length] = first;

        result.addAll(subs(pArr, rest));
        result.addAll(subs(proArr, rest));
        return result;
    }
}
