package LeetCode2;

import java.util.Arrays;

public class CountTheNoOfComputersUnlockingpermutation {
    public static void main(String[] args) {
        System.out.println(new CountTheNoOfComputersUnlockingpermutation().countPermutations(new int[] {3,2,1,3,3,4,6,8}));

    }
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int i = complexity[0];
        Arrays.sort(complexity);
        int x = binarySearch(complexity, i);
        return n - x;

    }

    public int binarySearch(int[] arr, int tar) {
        int n = arr.length;
        int s = 0;
        int e = n;
        int ans = -1;
        while (s < e) {
            int mid = s + (e - s)/2;
            if(arr[mid] == tar) {
                ans = mid;
                e = mid;
            } else if(arr[mid] > tar) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }




    //
    ublic int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int ans = 1;
        int mod = 1000000007;
        for (int i = 2; i < n; i++) {
            ans = (int) (((long) ans * i) % mod);
        }
        return ans;
    }
}
