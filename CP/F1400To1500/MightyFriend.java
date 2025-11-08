package F1400To1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MightyFriend {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            List<Integer> motu = new ArrayList<>();
            List<Integer> tomu = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    motu.add(a[i]);
                } else {
                    tomu.add(a[i]);
                }
            }

            Collections.sort(tomu);
            Collections.sort(motu, Collections.reverseOrder());

            int swaps = Math.min(k, Math.min(motu.size(), tomu.size()));
//            for (int i = 0; i < swaps; i++) {
//                if (tomu.get(i) < motu.get(i)) {
//                    int temp = tomu.get(i);
//                    tomu.set(i, motu.get(i));
//                    motu.set(i, temp);
//                }
//            }
            int i = 0;
            int j = 0;
            int ms = motu.size();
            int ts = tomu.size();
            while(swaps > 0 && i < ms && j < ts) {
                if(tomu.get(i) < motu.get(j)) {
                    int temp = tomu.get(i);
                    tomu.set(i, motu.get(j));
                    motu.set(j, temp);
                    i++; j++;
                    swaps--;
                } else {
                    j++;
                }
            }

            int motuSum = 0;
            for (int val : motu) {
                motuSum += val;
            }

            int tomuSum = 0;
            for (int val : tomu) {
                tomuSum += val;
            }

            System.out.println(tomuSum > motuSum ? "YES" : "NO");
        }
    }
}
