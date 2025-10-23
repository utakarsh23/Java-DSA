package BinarySearch;

public class newBs {
    public static void main(String[] args) {
        int[] arr = {7, 12, 45, 78, 88, 91, 101, 156, 200, 369, 400, 420, 500}; // sorted array
        int target = 92;
        System.out.println(bs(arr, target, 0, arr.length));
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0; //start index
        int end = arr.length-1; //end index
        /*
//        7, 12, 45, 78, 88, 91, 101, 156, 200, 369, 400, 420, 500
         arr[mid] = 101, 101 > 91,

         7, 12, 45, 78, 88, 91, 101
         arr[mid] = 78, 78 < 91

         88, 91, 101
        arr[mid] = 91, 91 == 91(target)
        return;

        //case 2, if not found
        7, 12, 45, 78, 88, 91, 101, 156, 200, 369, 400, 420, 500
        0   1   2   3   4   5   6    7    8   9     10   11   12
        target = 92;

        mid = 6,
        arr[mid] = 101,
        101 > 92,
         7, 12, 45, 78, 88, 91, 101
         0   1   2   3   4   5   6

        mid = 3,
        arr[mid] = 78,
        78 < 92,

         88, 91, 101
          4   5   6

         mid = 6 + 4 / 2 = 5;
         arr[mid] = 91,
         91 < 92,

        101
         6
         start = end = mid = 6
         arr[mid] = 101,
         101 > 92,
         end = mid -1;
         end = 5,
         start = 6,
         [start, end]
         [end, start]
         --> you can not expect the index lower than the start index to contain the target value.




         */
        while(start < end) {
            int mid = (start+end)/2; //mid index
            if(arr[mid] < target) {
                //then this means the left portion of the array is also smaller, so we leave that portion.
                //for doing so, we change the index of the start index, so the range changes to [newStart, end]
                //mid + 1 because we've already checked mid element, so no point in keeping it in the range nay further
                start = mid + 1;
            } else if (arr[mid] > target) {
                //this means that the right portion of the array os larger that the target element.
                //for doing so we have to move the index of end to mid,
                end = mid;
            } else {
                //this case means the element is the middle element,
                return mid;
            }
        }
        return -1;
    }

    static int bs(int[] arr, int tar, int s, int e) {
        int a = s + (e - s)/2;
        if(s > e) return -1;
        if(arr[a] == tar) return a;
        if(arr[a] > tar) return bs(arr, tar, s, a);
        return bs(arr, tar, s+1, e);
    }
}
