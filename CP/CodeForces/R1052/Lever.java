package CodeForces.R1052;

import LeetCode.STL;

import java.util.Scanner;

public class Lever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >= 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            int maxDiff = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) {
                    maxDiff = Math.max(maxDiff, a[i] - b[i]);
                }
            }
            System.out.println(maxDiff);
//            System.out.println(func(arr, arr1, 1));
        }
//            System.out.println(func(new int[] {1, 1, 4, 5, 1, 4}, new int[] {1, 9, 1, 9, 8, 1}, 1));

    }
    static int func(int[] arr, int[] arr1, int i) {
        int c1 = 0;
        int c2 = 0;
        for (int q = 0; q < arr.length; q++) {
            if(arr[q] > arr1[q]) {
                arr[q]--;
                c1++;
            } else if (arr[q] < arr1[q]) {
                arr[q]++;
                c2++;
            }
        }
        if(c1 == 0) return i;
        if(c1 + c2 == 0) return i;
        return func(arr, arr1, ++i);
    }
}
