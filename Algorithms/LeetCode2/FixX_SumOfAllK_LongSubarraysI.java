package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixX_SumOfAllK_LongSubarraysI {
    public static void main(String[] args) {
        FixX_SumOfAllK_LongSubarraysI fx = new FixX_SumOfAllK_LongSubarraysI();
        int[] xSum = fx.findXSum(new int[]{9,2,2}, 3, 3);
        System.out.println(Arrays.toString(xSum));
    }

    public class Pins {
        int val;
        int freq;

        public Pins(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] arr = new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {
            arr[i] = helper(nums, i, i+k, x);
        }
        return arr;
    }
    public int helper(int[] nums, int s, int k, int x) {
        int len = nums.length;
        int[] arr = new int[50];
        for (int i = s; i < k; i++) {
            arr[nums[i] - 1]++;
        }
        List<Pins> pinList = new ArrayList<>();
        int len1 = arr.length;
        for (int i = 0; i < len1; i++) {
            if(arr[i] != 0) {
                arrangeArray(new Pins(i+1, arr[i]), pinList);
            }
        }

        int ans = 0;
        int al = pinList.size();
        for (int i = 0; i < x && i < al; i++) {
            Pins p = pinList.get(i);
            ans += p.val * p.freq;
        }
        return ans;
    }

    public void arrangeArray(Pins pins, List<Pins> pinsList) {
        int len = pinsList.size();
        if(len == 0) {
            pinsList.add(pins);
            return;
        }
        for (int i = 0; i < len; i++) {
            if(pinsList.get(i).freq < pins.freq) {
                pinsList.add(i, pins);
                return;
            } else if(pinsList.get(i).freq == pins.freq) {
                while (i < len && pinsList.get(i).val > pins.val) {
                    i++;
                }
                pinsList.add(i, pins);
                return;
            }
        }
        pinsList.add(pins);
    }

//    The x-sum of an array is calculated by the following procedure:
//    Count the occurrences of all elements in the array.
//    Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
//    Calculate the sum of the resulting array.
//
//    Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

//    ------

//            1 <= n == nums.length <= 50
//            1 <= nums[i] <= 50
//            1 <= x <= k <= nums.length


}

