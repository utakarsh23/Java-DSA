package GFG;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }
    int search(int[] arr, int key) {
        // Complete this function
        int pivots = pivot(arr);
        if(pivots == -1) {
            return binarySearch(arr, 0, arr.length-1, key);
        }
        if(arr[pivots] == key) {
            return pivots;
        }
        if(key >= arr[0]) {
            return binarySearch(arr, 0, pivots-1, key);
        }
        return binarySearch(arr, pivots+1, arr.length-1, key);
    }
    public int pivot(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start < end) {
            int mid = start+(end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if(arr[start] >= arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start+(end-start)/2;
            if(target < arr[mid]) {
                end = mid-1;
            } else if(target > arr[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
