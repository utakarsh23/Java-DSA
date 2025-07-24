package AssignmentOne;

import java.util.Arrays;
import java.util.Scanner;

public class AssOne {
    public static void main(String[] args) {
        System.out.println(questionSeventeen("A Strange Man"));
    }
    static void questionTen() {
        int i = 0;
        while (true){
            System.out.println("Who is the inventor of Cpp ? ");
            Scanner input = new Scanner(System.in);
            String ans = input.nextLine();
            if(ans.equals("Bjarne Stroustrup")) {
                System.out.println("Good");
                break;
            } else if (i == 3) {
                System.out.println("Bjarne Stroustrup");
                break;
            } else {
                System.out.println("try again");
                i++;
            }
        }
    }

    static int questionEleven(int n) {
        StringBuilder t = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            t.append(n);
            ans += Integer.parseInt(String.valueOf(t));
        }
        return ans;
    }

    static double questionTwelve(int a, int b) {
        //a^x = b; x = ?
        return Math.log(b)/Math.log(a);
    }

    static boolean questionThirteen(int n) {
        String t = String.valueOf(n);
        int j = 0;
        int ans = 0;
        for (int i = 0; i < t.length(); i++) {
            ans += (t.charAt(i) - 48) ^ j;
            j++;
        }
        return ans == n;
    }

    static String questionFourteen(int n) {
        int ans = 0;
        while (n != 0) {
            ans = n % 10;
            n/= 10;
        }
        return (ans & 1) == 0 ? "Evenish" : "Oddish";
    }

    static int[][] questionFifteen(int n) {
        int[][] arr = new int[n][n];
        Arrays.fill(arr, n);
        return arr;
    }

    //in pro
    static int questionSixteen(int n) {
        int[] arr = new int[n];
        for (int i = 1; i < 10; i++) {
            if(n % i == 0) {
                for (int j = i; j < n; j+= i) {
                    arr[j] = -1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == -1) {
                ans += arr[i];
            }
        }
        return ans;
    }

    static String questionSeventeen(String input) {
        StringBuilder s = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                s.append((char) ('Z' - (c - 'A')));
            } else if (c >= 'a' && c <= 'z') {
                s.append((char) ('z' - (c - 'a')));
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

}
