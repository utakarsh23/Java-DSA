package LeetCode;

import java.util.*;

class nextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i < nums1.length; i++) {
            int j = map.get(nums1[i]);
            j++;
            if(j < nums2.length-1 && ans[i] < nums2[j] && nums2[j] > nums1[i]) {
                ans[i] = nums2[j];
            }
        }
        return ans;
    }

    static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums1.length; i++) {
            int indexInNums2 = map.get(nums1[i]);

            for (int j = indexInNums2 + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse nums2 and build the next greater map
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // For any remaining elements in the stack, there is no greater element
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}