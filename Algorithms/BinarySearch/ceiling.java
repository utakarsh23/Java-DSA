package BinarySearch;

//finding teh number which is >= the target element inside the array(Ceiling)
public class ceiling {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 13, 20, 24, 29, 34, 40, 48, 60}; //sorted array
        int target = 35;
        System.out.println(search(arr, target));
    }
    static int search(int[] arr, int target) { //Binary_search function
        int start = 0; //start = 0th index, 
        int end = arr.length -1; //mid = middle index
        while(start <= end) { //while start <= end;, if this fails then that means middle has crossed each other and mid is found
            int mid = start - (start-end)/2; //formula for the mid, ie. it is as same as (start-end)/2
            //
            if(target > arr[mid]) { //if target > middle element then it gies to the right side checking as the array is sorted
                start = mid + 1; //start will be changes to the middle element found
            } else if(target < arr[mid]) { //if target < middle element them it goes to check the left side checking 
                end = mid -1; //so end will change not the starting si end will be mid -1 
            } else {
                return mid; //if none of it is correct(ie. the first mid(start(0) - (start(0) - end(len.arr-1))/2) is the target 
            }
        }
        return start; //returning start because if not found then the end will be the number next to the target element 
    } // 
}