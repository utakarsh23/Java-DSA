package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
    static public int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int i = 0;
        int ans = 0;
        for(int x : map.keySet()) { //wrong cause map gives random values not in order in the keySet
            if(i == map.size()-k)  {
                ans = x;
                break;
            }
            i++;
        }
        return ans;
    }
    static public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
