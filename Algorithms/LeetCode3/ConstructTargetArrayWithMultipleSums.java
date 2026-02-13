package LeetCode3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
        System.out.println(new ConstructTargetArrayWithMultipleSums().isPossible(new int[] {1, 1000000000}));
    }
    public boolean isPossible(int[] target) {
        int n = target.length;
        int sum = n;
        Arrays.sort(target);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(1);
        }
        int i = 0;
        while(i < n && !pq.isEmpty()) {
            int t = pq.poll();
            int ts = sum;
            pq.offer(sum);
            sum = (2 * sum) - t;
            if(ts == target[i]) {
                i++;
                pq.poll();
            } else if(ts > target[i]) {
                return false;
            }
        }
        return true;
    }
}
