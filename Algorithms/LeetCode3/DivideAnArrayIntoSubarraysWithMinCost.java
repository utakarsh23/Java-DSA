package LeetCode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class DivideAnArrayIntoSubarraysWithMinCost {
    public static void main(String[] args) {
        System.out.println(new DivideAnArrayIntoSubarraysWithMinCost().minimumCost(new int[] {1,3,2,6,4,2}, 3, 3));
    }

    public long minimumCost(int[] nums, int k, int dist) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
        // item, count

        long sum = Long.MAX_VALUE; //sum for k-1 elements in the window.
        long ans = (long)nums[0];
        int n = nums.length;
        for(int i = 0; i < dist+1; i++) {
            tmap.put(nums[i], tmap.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        // for(int i = 0; i < Math.min(k, n); i++) {
        //     int t = tmap.last();
        //     sum += t;
        //     lis.add(t);
        // }

        // for(int x : lis) {
        //     tmap.insert(x);
        // }

        k--;
        for(int i = 1; i < n-dist; i++) {

            int ele = tmap.get(nums[i-1]); // get curr no of ele present inside the widnow.

            if(ele == 1) { //if only one(last wondow), remove from array.
                tmap.remove(nums[i-1]);
            } else { //if more than 1, then reduce the count.
                tmap.put(nums[i-1], ele - 1);  
            }

            tmap.put(nums[i+dist], tmap.getOrDefault(nums[i+dist], 0) + 1);  // add next window element.

            long tsum = 0;
            //now remove top(k-1) ele from the map
            for(int j = 0; j < k; j++) {
                int t = tmap.lastKey();

                int tele = tmap.get(t); //get the top ele,     
                if(tele == 1) {
                    tmap.remove(t);
                } else {
                    tmap.put(t, tmap.get(t)-1); //reduce count.
                }
                list.add(t); //add them to the list so we can add them in the map later, 
                tsum += (long)t;
            }
            System.out.println(list);
            while(!list.isEmpty()) {
                int t = list.removeLast();
                tmap.put(t, tmap.getOrDefault(t, 0) + 1);
            }
            System.out.println(tsum);
            sum = Math.min(sum, tsum);
        }
        ans += sum;
        return ans;
    }

    // 1,3,2,6,4,2,7,9,5 : k = 3, dist = 3.

    // 1,3,2,6,4,2,7,9,5 : k = 3, dist = 3. k = (3-1)
    // 1,3,2,6,4,2,7,9,5 : k = 2
    // _                   

    /* 
    We can try a sliding window with length distance starting from index 1, for each 
    window, we take (k-1) items from heap and sum them and check minimum for it. 
    when we move the window, we remove the first element and add the last(latest) element.

    Maybe we can try using trees for max and min addition and deletion??
    */ 
}