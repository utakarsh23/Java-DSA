package LeetCode2;

import java.util.Arrays;

public class MaxCandiesAllocatedToKChildren {

    public static void main(String[] args) {
        System.out.println(new MaxCandiesAllocatedToKChildren().maximumCandies(new int[] {9,10,1,2,10,9,9,10,2,2}, 3));
    }
    public int maximumCandies(int[] candies, long k) {

        Arrays.sort(candies);
        int n = candies.length;
        int s = 1;
        int e = candies[n-1];
        int mid = s + (e - s)/2;;
        int ans = 0;
        while(s <= e) {
            mid = s + (e - s)/2;
            if(search(candies, mid , k)) {
                ans = Math.max(ans, mid);
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return ans;
    }

    //bs b/w min and max

    //1 2 2 2 9 9 9 10 10 10
    //9
    //
    //return t/f, then min/max the s and e
    private boolean search(int[] arr, long val, long k) {
        long c = 0;
        for(int i = arr.length-1; i>= 0; i--) {
            c += (long)arr[i]/val;
        }
        return c >= k;
    }
}
