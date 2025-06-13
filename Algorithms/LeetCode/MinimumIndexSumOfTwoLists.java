package LeetCode;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"happy","sad","good"}, list2 = {"sad","happy","good"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }
    static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);
                if (indexSum < minSum) {
                    ans.clear();
                    ans.add(list2[i]);
                    minSum = indexSum;
                } else if (indexSum == minSum) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
