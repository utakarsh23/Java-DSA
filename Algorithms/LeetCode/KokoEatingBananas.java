package LeetCode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8));
    }
    static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int x : piles) {
            max = Math.max(max, x);
        }
        int i = 1;
        int j = max;
        while (i < j) {
            int mid = i + (j - i)/2;
            if(completedBananas(mid, piles, h)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    private static boolean completedBananas(int k, int[] arr, int h) {
        int hours = 0;
        for (int x : arr) {
//            hours += (x + k - 1)/k;
            hours += Math.ceilDiv(x, k);
        }
        return hours <= h;
    }
}
