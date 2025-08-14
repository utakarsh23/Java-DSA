package CodeChef.S199;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] arr1 = new int[n];

            Arrays.fill(arr1, 1);

            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            int max = 0;
            for(int x : map.values()) {
                max = Math.max(max, x);
            }
            Arrays.fill(arr1, 1);
            int c = 1;
            for(int i = 0; i < n; i++) {
                if(arr[i] != arr1[i]) {
                    c++;
                }
            }
            if(c == 1) {
                System.out.println(1);
            } else {
                System.out.println(c);
            }
        }
    }
}
