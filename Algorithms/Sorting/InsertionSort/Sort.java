package Sorting.InsertionSort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        // Small sanity check
        int[] arrr = {8, 5, 7, 3, 9};
        insertionSort(arrr);
        System.out.println(Arrays.toString(arrr));
        // output -> [3, 5, 7, 8, 9]

        //dry run
        // initial array = [8, 5, 7, 3, 9]

        // i = 0
        // j = i + 1 = 1
        // nums[j] = 5, nums[j - 1] = 8
        // 5 < 8 -> true -> swap
        // array becomes [5, 8, 7, 3, 9]

        // j-- → j = 0
        // j > 0 -> false -> exit

        // i = 1
        // j = i + 1 = 2
        // nums[j] = 7, nums[j - 1] = 8
        // 7 < 8 -> true -> swap
        // array becomes [5, 7, 8, 3, 9]

        // j-- → j = 1
        // nums[j] = 7, nums[j - 1] = 5
        // 7 < 5 -> false -> exit
        // inner loop ends

        // i = 2
        // j = i + 1 = 3
        // nums[j] = 3, nums[j - 1] = 8
        // 3 < 8 -> true -> swap
        // array becomes [5, 7, 3, 8, 9]

        // j-- → j = 2
        // nums[j] = 3, nums[j - 1] = 7
        // 3 < 7 -> true -> swap
        // array becomes [5, 3, 7, 8, 9]

        // j-- → j = 1
        // nums[j] = 3, nums[j - 1] = 5
        // 3 < 5 -> true -> swap
        // array becomes [3, 5, 7, 8, 9]

        // j-- → j = 0
        // j > 0 -> false

        // i = 3
        // j = i + 1 = 4
        // nums[j] = 9, nums[j - 1] = 8
        // 9 < 8 → false → break
        // inner loop ends

        // final sorted array = [3, 5, 7, 8, 9]

        System.out.println();

        System.out.println("randomised array");
        testInsertionSort(generateRandomArray(100));        // 10^2
        testInsertionSort(generateRandomArray(1_000));      // 10^3
        testInsertionSort(generateRandomArray(1_0000));      // 10^3
        testInsertionSort(generateRandomArray(100_000));    // 10^5
        testInsertionSort(generateRandomArray(100_0000));    // 10^5

        System.out.println("\nsorted array");
        testInsertionSort(generateSortedArray(100));
        testInsertionSort(generateSortedArray(1_000));
        testInsertionSort(generateSortedArray(1_0000));
        testInsertionSort(generateSortedArray(100_000));
        testInsertionSort(generateSortedArray(100_000_0));

        System.out.println("\nreversed array");
        testInsertionSort(generateReversedArray(100));
        testInsertionSort(generateReversedArray(1_000));
        testInsertionSort(generateReversedArray(1_000_0));
        testInsertionSort(generateReversedArray(100_000));
        testInsertionSort(generateReversedArray(100_000_0));

    }

    static void insertionSort(int[] nums) { //function of sorting using insertion
        for (int i = 0; i < nums.length-1; i++) { //loop for accessing elements,
            for (int j = i+1; j > 0; j--) { //sec ond loop for accessing next elements, i + 1.
                if (nums[j] < nums[j-1]) { //base case, if the bigger indexed element is greater then swap it with the lower indexed.
                    swap(nums, j, j-1); //swap
                } else {
                    break; //if there's no base case, break and move forward.
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void testInsertionSort(int[] arr) {

        long start = System.nanoTime();
        insertionSort(arr);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;
        System.out.println("Size: " + arr.length + " | Time: " + timeMs + " ms");
    }

    static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }


    static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static int[] generateReversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
