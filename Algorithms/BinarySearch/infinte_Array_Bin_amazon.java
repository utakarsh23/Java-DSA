package BinarySearch;

public class infinte_Array_Bin_amazon {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
            int target = 70;
            System.out.println(ans(arr, target));
    }
    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while(target > arr[end]) {
            int temp = end + 1; //temp--> later to be start 
            end = end + (end - start +1)*2; // end + sixing by index*2
            start = temp;
        }
        return Binarysearch(arr, target, start, end);
    }
    static int Binarysearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start - (start - end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
