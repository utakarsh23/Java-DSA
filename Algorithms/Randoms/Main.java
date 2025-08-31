package Randoms;

import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        List<String> list = List.of("27", "28", "29", "30", "31", "01", "02", "03", "04", "05", "06");

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s= sc.nextLine();
            String[] w = s.split(" ");
            if(!w[1].equals("AUG") && !w[1].equals("SEP") || !w[2].equals("2025")) {
                System.out.println("NO");
            } else if(list.contains(w[0])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean palin(int n) {
        int temp = n;
        int ans = 0;
        while (n != 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n /= 10;
        }
        return ans == temp;
    }

    static List<Integer> generatePalin(int n) {
        int size = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            StringBuilder s = new StringBuilder().append(i);
            if(i < 10) {
                list.add(Integer.parseInt(s.toString()));
                list.add(Integer.parseInt(s.append(s).toString()));
            } else {
                String t = new StringBuilder(s).deleteCharAt(s.length() - 1).reverse().toString();
                s.append(t);
                list.add(Integer.parseInt(s.toString()));
                s.insert(s.length() / 2, s.charAt(s.length() / 2));
                list.add(Integer.parseInt(s.toString()));
            }
        }
        Collections.sort(list);
        return list;
    }
}