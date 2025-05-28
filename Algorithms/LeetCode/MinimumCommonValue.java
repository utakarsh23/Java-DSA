package LeetCode;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {6, 7, 8};
        System.out.println(getCommon(arr1, arr2));
    }
    static public int getCommon(int[] nums1, int[] nums2) {
        int ans = -1;
        int p1 = 0;
        int p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            while(p2 < nums2.length && p1 < nums1.length && nums1[p1] < nums2[p2]) {
                p1++;
            }
            while(p1 < nums1.length && p2 < nums2.length && nums1[p1] > nums2[p2]) {
                p2++;
            }
            if(p1 < nums1.length && p2 < nums2.length && nums1[p1] == nums2[p2]) {
                return nums1[p1];
            }
        }
        // while(p1 < nums1.length && nums1[p1] != nums2[p2]) {
        //     p1++;
        //     ans = p1;
        // }
        // while(p2 < nums2.length && nums1[p1] != nums2[p2]) {
        //     p2++;
        //     ans = p2;
        // }
        return ans;
    }
}
