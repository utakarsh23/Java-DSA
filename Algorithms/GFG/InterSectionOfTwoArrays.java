package GFG;

import java.util.*;

public class InterSectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(intersectionWithDuplicates(new int[] {1, 2, 3, 4}, new int[] {4, 5, 6}));
    }
    static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        Set<Integer> li = new HashSet<>();
        while(i < a.length && j < b.length) {
            if(a[i] > b[j]) {
                j++;
                continue;
            } else if (a[i] < b[j]) {
                i++;
                continue;
            } else {
                li.add(a[i]);
            }
            i++; j++;
        }
        return new ArrayList<>(li);
    }

    // m2
    static ArrayList<Integer> intersectionWithDuplicates1(int[] a, int[] b) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        return result;
    }
}
