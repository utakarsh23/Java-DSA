package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.List;

class TeemoAttacking {
    public static void main(String[] args) {
        TeemoAttacking ta = new TeemoAttacking();
        int[] timeSeries = {1,4};
        int duration = 2;
        System.out.println(ta.findPoisonedDuration(timeSeries, duration));
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count=0;
        for(int i=0;i<timeSeries.length-1;i++){
            count+=Math.min(duration,timeSeries[i+1]-timeSeries[i]);
        }
        count+=duration;

        return count;
    }}