package CodeChef.S203;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    //brute force
    public static void main (String[] args) throws Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long t = sc.nextLong();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(minLastAndFirst(arr, n)).append(" ");
            while (q-- > 0) {
                int p = sc.nextInt()-1;
                int x = sc.nextInt();
                arr[p] = x;
                sb.append(minLastAndFirst(arr, n)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int minLastAndFirst(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int j = 1; j < n; j++) {
            //if i is odd - bob
            //bob will start from here

            if(j % 2 != 0) {
                //bob
                int max = Math.max(list.getFirst(), list.getLast());
                if(list.getFirst() == max) {
                    list.addFirst(arr[j]);
                } else {
                    list.addLast(arr[j]);
                }
            } else {
                //alice
                //here alice will try to keep the max value at the front or back
                int max = Math.max(list.getFirst(), list.getLast());
                if(list.getFirst() == max) {
                    list.addLast(arr[j]);
                } else {
                    list.addFirst(arr[j]);
                }
            }
        }
        return Math.min(list.getFirst(), list.getLast());
    }

}
