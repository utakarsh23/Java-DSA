package LeetCode.LinkedLists;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
    static public int largestRectangleArea(int[] heights) {
        int[] arr = new int[heights.length];
        for(int i = 1; i <= heights.length; i++) {
            updateList(arr, heights, i);
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static void updateList1(int[] arr, int[] heights, int index) {
        for(int i = 0; i < index; i++) {
            int j = i;
            int ans = 1;
            while(j < index-1 && heights[j] < heights[j + 1]) {
                j++;
                ans++;
            }
            j = i;
            while(j > 0 && heights[j] < heights[j - 1]) {
                j--;
                ans++;
            }
            ans--;
            if(ans == 0) {
                arr[i] = heights[i];
            } else if (heights[i] <= ans * heights[i]) {
                arr[i] = ans * heights[i];
            }
        }
    }

    static void updateList(int[] arr, int[] heights, int index) {
        int n = heights.length;
        int i = index;

        int height = heights[i];
        int left = i, right = i;

        while (left - 1 >= 0 && heights[left - 1] >= height) {
            left--;
        }

        while (right + 1 < n && heights[right + 1] >= height) {
            right++;
        }

        int width = right - left + 1;
        arr[i] = width * height;
    }
}
