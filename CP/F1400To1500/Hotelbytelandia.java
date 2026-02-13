package F1400To1500;

import java.util.Arrays;
import java.util.Scanner;

public class Hotelbytelandia {
//    public static void Main (String[] args) throws Exception
//    {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            int[] arr1 = new int[n];
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//                min = Math.min(arr[i], min);
//                max = Math.max(arr[i], max);
//            }
//            for (int i = 0; i < n; i++) {
//                arr1[i] = in.nextInt();
//                min = Math.min(arr1[i], min);
//                max = Math.max(arr1[i], max);
//            }
//            int[] buildArray = new int[1001];
//            Arrays.fill(buildArray, arr[0]-1, arr1[0]-1, 1);
//            buildArray[arr1[0]-1]--;
//            for (int i = 1; i < n; i++) {
//                for (int k = arr[i]-1; k < arr1[i]-1; k++) {
//                    buildArray[k]++;
//                }
//                buildArray[arr1[i]-1]--;
//            }
//
//            int nm = Integer.MIN_VALUE;
//            int s = min-1;
//            int e = max;
//            while (s < e) {
//                int j = s+1;
//                while (j < max && buildArray[j] > 1) {
//                    j++;
//                }
//                nm = Math.max(j - s, nm);
//                s = j;
//            }
//            System.out.println(nm);
//        }
//    }

//    public static void Main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            int[] dep = new int[n];
//
//            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//                min = Math.min(min, arr[i]);
//                max = Math.max(max, arr[i]);
//            }
//            for (int i = 0; i < n; i++) {
//                dep[i] = in.nextInt();
//                min = Math.min(min, dep[i]);
//                max = Math.max(max, dep[i]);
//            }
//
//            int[] diff = new int[max + 2];
//            for (int i = 0; i < n; i++) {
//                diff[arr[i]]++;
//                diff[dep[i] + 1]--;
//            }
//
//            int maxGuests = 0, curr = 0;
//            for (int i = min; i <= max; i++) {
//                curr += diff[i];
//                maxGuests = Math.max(maxGuests, curr);
//            }
//
//            System.out.println(maxGuests);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] dep = new int[n];

            Arrays.sort(arr);
            Arrays.sort(dep);
            int i = 0, j = 0, curr = 0, maxGuests = 0;
            while (i < n && j < n) {
                if (arr[i] <= dep[j]) {
                    curr++;
                    maxGuests = Math.max(maxGuests, curr);
                    i++;
                } else {
                    curr--;
                    j++;
                }
            }
            System.out.println(maxGuests);
        }
    }

}
