package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class COuntDistinctElemetsInEveryWindow {
    public static void main(String[] args) {
            int arr[] = {1, 2, 1, 3, 4, 2, 3}; int k = 4;
        System.out.println(countDistinct(arr, k));
    }
    static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length-k+1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i+k; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            res.add(map.size());
        }
        return res;
    }
}
