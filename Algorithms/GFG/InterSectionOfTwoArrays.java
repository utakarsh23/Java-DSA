package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InterSectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(intersectionWithDuplicates(new int[] {1, 2, 1, 3, 1}, new int[] {3, 1, 3, 4, 1}));
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
            } else if (a[i] < b[j]) {
                i++;
            } else {
                li.add(a[i]);
            }
            i++; j++;
        }
        ArrayList<Integer> li1 = new ArrayList<>();
        for (int k = 0; k < li.size(); k++) {
            li1.add(li.hashCode());
        }
        return li1;
    }
}
