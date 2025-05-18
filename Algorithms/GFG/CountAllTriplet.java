package GFG;

import java.util.*;

public class CountAllTriplet {
    public static void main(String[] args) {
        System.out.println(countTriplets1(new int[] {1, 2, 2, 2, 3, 4}, 7));
    }
    static int countTriplets(int[] arr, int target) {
        // Code Here
        Set<List<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                mp.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[] {i, j});

            }
        }
        for(int i = 0; i < n; i++) {
            int rem = target-arr[i];
            if(mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for(int[] p : pairs) {
                    if(p[0] != i && p[1] != i) {
                        List<Integer> current = Arrays.asList(i, p[0], p[1]);
                        Collections.sort(current);
                        resSet.add(current);
                    }
                }
            }
        }
        return resSet.size();
    }

        static int countTriplets1(int[] arr, int target) {
            Arrays.sort(arr); // O(n log n)
            int n = arr.length;
            int count = 0;

            for (int i = 0; i < n - 2; i++) {
                int j = i + 1;
                int k = n - 1;

                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == target) {
                        if (arr[j] == arr[k]) {
                            // All elements between j and k are the same
                            int len = k - j + 1;
                            count += (len * (len - 1)) / 2; // nC2 combinations
                            break;
                        } else {
                            int left = 1;
                            int right = 1;
                            while (j + 1 < k && arr[j] == arr[j + 1]) {
                                left++;
                                j++;
                            }
                            while (k - 1 > j && arr[k] == arr[k - 1]) {
                                right++;
                                k--;
                            }
                            count += left * right;
                            j++;
                            k--;
                        }
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            return count;
        }
}
