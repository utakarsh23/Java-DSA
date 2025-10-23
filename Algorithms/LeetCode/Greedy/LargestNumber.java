package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {0, 0, 1, 0, 5, 1}));
        //5 1 1 0 0 0
//        501100
//        511000
        /*
                0   0   1                  0    5    1
               /         \                  /        \
           0  0           1            0   5           1

         0      0         |         0         5        |

         |      |         |         |         |        |

         */
    }
    public static String largestNumber1(int[] nums) {
        int len = nums.length-1;
        return helper(nums, 0, len, "");
        //3,30,34,5,9
        /*
                        3, 30, 34                  5, 9
                    3, 30        34              5      9
                3        30                          
                    330
                    303
                    -
                    33034                            59
                    34330                            95
                    -                                    -
                    9534330
        
        //10, 2
        
                10      2
                   102
                   210
        
        */
    }

    static String helper(int[] arr, int l, int r, String ans) {
        if (l == r)
            return String.valueOf(arr[l]);

        String le = helper(arr, l, (l + r) / 2, ans);
        String ri = helper(arr, (l + r) / 2 + 1, r, ans);

        if((le+ri).compareTo(ri+le) > 0) {
            ans = le+ri;
        } else {
            ans = ri+le;
        }
        return ans;
    }




    public static String largestNumber(int[] nums) {
        // Step 1: convert to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Step 2: perform custom merge sort
        List<String> sorted = mergeSort(arr, 0, arr.length - 1);

        // Step 3: handle edge case (all zeros)
        if (sorted.get(0).equals("0")) return "0";

        // Step 4: build final string
        StringBuilder sb = new StringBuilder();
        for (String s : sorted) sb.append(s);
        return sb.toString();
    }

    static List<String> mergeSort(String[] arr, int l, int r) {
        if (l == r) {
            return new ArrayList<>(Collections.singletonList(arr[l]));
        }

        int mid = (l + r) / 2;
        List<String> left = mergeSort(arr, l, mid);
        List<String> right = mergeSort(arr, mid + 1, r);

        return merge(left, right);
    }

    static List<String> merge(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Custom merge based on concatenation comparison
        while (i < left.size() && j < right.size()) {
            String a = left.get(i);
            String b = right.get(j);

            if ((a + b).compareTo(b + a) >= 0) {
                merged.add(a);
                i++;
            } else {
                merged.add(b);
                j++;
            }
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }
}