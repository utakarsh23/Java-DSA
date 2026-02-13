package Randoms;

import java.util.Arrays;
import java.util.Scanner;
//https://www.codechef.com/START211D
public class SubArrayMaxims {
//    public static void Main(String[] args) throws java.lang.Exception {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                if(sum == arr[i]) {
//                    int j = i + 1;
//                    while(j < n && arr[j] == sum) j++;
//                    if(j < n) swap(arr, i, j);
//                }
//                sum += arr[i];
//            }
//            for(int i = 0; i < n; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void Main(String[] args) throws java.lang.Exception {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                if(sum == arr[i]) {
//                    int j = i - 1;
//                    if(j >= 0) swap(arr, i, j);
//                    else swap(arr, i, j);
//                }
//                sum += arr[i];
//            }
//            for(int i = 0; i < n; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }

    //correct way,
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int first = arr[n-1];
            int li = n-1;
            while (arr[li] == first) {
                System.out.print(arr[li] + " ");
                li--;
            }
            for(int i = 0; i <= li; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

}
