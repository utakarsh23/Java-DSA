package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FindAllTripWithXZeroSum {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int j = 0; j < arr.length; j++) {
            for(int k = j + 1; k < arr.length; k++) {
                int val = -1 * (arr[k] + arr[j]);
                if(map.containsKey(val)) {
                    for(int i : map.get(val)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
            map.putIfAbsent(arr[j], new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        return ans;
    }
}