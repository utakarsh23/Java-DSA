package CodeChef.S198;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        char[] ars = s.toCharArray();
//        Arrays.sort(ars);
//        s = new String(ars);
//        if(s.equals("act")) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//
//        System.out.println(func(new int[] {12, 18, 2, 28, 16}));
//        Scanner input = new Scanner(System.in);
//        int t = input.nextInt();
//        while(t-- != 0) {
//            // int n = input.nextInt();
//            int[] arr = new int[4];
//            for(int i = 0; i < arr.length; i++) {
//                arr[i] = input.nextInt();
//            }
//            int s1 = arr[0] + arr[1];
//            int s2 = arr[2] + arr[3];
//            int s = s1-s2;
//            if((s1 - s2)%2 == 0) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//
//        }
//    }
//
//    static int func(int[] arr) {
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i < arr.length -1; i++) {
//            int ans = arr[i] + (arr[i+1]/2);
//            min = Math.min(ans, min);
//        }
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i+1; j < arr.length; j++) {
//                if(j == i+1) {
//                    int ans = arr[i] + (arr[i+1]/2);
//                    min = Math.min(ans, min);
//                } else {
//                    min = Math.min(arr[i] + arr[j], min);
//                }
//            }
//        }
//        return min;
//    }

    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "ghj";
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = input.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];

            for (int i = 0; i < n; i++) A[i] = input.nextInt();
            for (int i = 0; i < n; i++) B[i] = input.nextInt();

            // Make count arrays size n+5 just to be safe
            int[] count = new int[n + 5];
            int[] common = new int[n + 5];

            for (int i = 0; i < n; i++) {
                count[A[i]]++;
                count[B[i]]++;
                if (A[i] == B[i]) {
                    common[A[i]]++;
                }
            }

            int mex = 0;
            while (true) {
                if (count[mex] == 0 || (count[mex] == 1 && common[mex] == 1)) {
                    sb.append(mex).append("\n");
                    break;
                }
                mex++;
            }
        }

        System.out.print(sb);
    }
}