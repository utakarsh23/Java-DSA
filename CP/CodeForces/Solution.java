package CodeForces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
//            List<Integer> li = sieveList(n);
//            for(int i = li.size()-1; i >= 0; i--) {
//                if(n % li.get(i) == 0) {
//                    System.out.println(li.get(i));
//                    break;
//                }
//            }
            long max = -1;

            while (n % 2 == 0) {
                max = 2;
                n /= 2;
            }

            for (long i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    max = i;
                    n /= i;
                }
            }
            if (n > 2) {
                max = n;
            }
            System.out.println(max);
        }
    }
    public static List<Integer> sieveList(int n) {
        int[] arr = sieveArray(n);
        List<Integer> li = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(arr[i] == 1) {
                li.add(i);
            }
        }
        return li;
    }
    public static int[] sieveArray(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        arr[0] = arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(arr[i] == 1) {
                for (int j = i * i; j <= n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }

    //

}