package LeetCode;

class medianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    //TC = m+n
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                arr[k++] = nums1[i];
                i++;
            } else {
                arr[k++] = nums2[j];
                j++;
            }
        }
        while(i < nums1.length) {
            arr[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        if(arr.length % 2 == 0) {
            return (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) /2;
        }
        return arr[arr.length/2];
    }
}