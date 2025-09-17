package AssignmentOne;

import java.util.*;

//questions skipped as already done in class/boring/easy/tp
//34, 35, 36, 28, 27, 21

public class AssignOne {
    public static void main(String[] args) {
        //

    }


    static Map<String, Integer> questionFive(int[] marks) {
        Map<String, Integer> map = new HashMap<>();

        for (int mark : marks) {
            switch (mark / 10) {
                case 10, 9, 8 -> map.put("81 to 100", map.getOrDefault("81 to 100", 0) + 1);
                case 7, 6 -> map.put("61 to 80", map.getOrDefault("61 to 80", 0) + 1);
                case 5, 4 -> map.put("41 to 60", map.getOrDefault("41 to 60", 0) + 1);
                default -> map.put("Less than 40", map.getOrDefault("Less than 40", 0) + 1);
            }
        }
        return map;
    }

    static int questionSix(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    static void questionSeven(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int questionEight(int n) {
        int reversed = 0;
        int temp = n; //for m2
        //m1
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        //m2
//        int ans = Integer.parseInt(new StringBuilder(Integer.toString(temp)).reverse().toString());
        return reversed; // ans
    }

    static int questionNine(String s) {
        String[] words = s.toLowerCase().split("\\s+"); // Split by spaces
        String target = s.toLowerCase();

        int count = 0;
        for (String w : words) { //enhanced for loop//for each loop
            if (w.equals(target)) {
                count++;
            }
        }
        return count;
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
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], n);
        }
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

    static boolean questionEighteen(int n) {
        long power = (long)Math.pow(n, 2); //power but using long as the power for long integers can eb greater than range of Integer
        while(n != 0) { // breaking case,
            if(n%10 != power%10) return false; //checking last digit for both are equal or not,
            n /= 10;
            power /= 10;
            //div by 10 to remove last digit
        }
        return true;
    }

    static boolean questionNineteen(int n) {
        //Harshad Number
        int temp = n; //temp to hold the value and check later
        int sum = 0; //
        while (n != 0) { //edge case
            sum += n%10; //adding the digits
            n /= 10; //removing last digit
        }
        return temp%sum == 0; //return true / false,
    }

    static boolean questionTwenty(long n) {
        //ISBN validity
        int sum = 0;
        int j = 0;
        for (int i = 1; i <= 10; i++) {
             sum += (int)(n%10 * i);
        }
        return sum%11 == 0;
    }

    static String questionTwentyTwo(int x, int sys) {
        //converts base 10 to others
        //System.out.println(Integer.toString(x, sys)); //inbuilt function to do it in one line
        // sys -> the number system to be converted
        String s = "0123456789ABCDEF"; //typical order of representation till hexadecimal
        StringBuilder sb = new StringBuilder(); //String but mutable
        while (x != 0) { //rep till the quotient is zero
            sb.append(s.charAt(x%sys)); //adding in string, (x%sys) means dividing the quotient by the required type
            //i.e for binary, x = 4, sys = 2, so 4%2 == 0, check string's 0th index, it'll be 0.
            x /= sys; // 4 / 2 = 2, so x = 2;
        }
        return new String(sb.reverse()); //reversing it, lower index to higher index
    }

    static Map<String, Integer> questionTwentyThree(String s) {

        Map<String, Integer> map = new HashMap<>(); // looks like a dictionary of key value bear
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                map.put("Alphabet", map.getOrDefault("Alphabet", 0) + 1); // for the key alphabet. We are increasing the count with each iteration of characters.
            } else if(s.charAt(i) == ' ') {
                map.put("Spaces", map.getOrDefault("Spaces", 0) + 1); // ditto but for Spaces
            } else if (s.charAt(i)-48 >= 0 && s.charAt(i)-48 <= 9) {
                map.put("Digits", map.getOrDefault("Digits", 0) + 1); // digits
            } else {
                map.put("Special Characters", map.getOrDefault("Special Characters", 0) + 1);
            }
        }
        return map;
    }

    static void questionTwentyFour(){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = input.nextInt();
            if (digits[i] < 0 || digits[i] > 9) {
                return;
            }
        }

        Set<Integer> uniqueNumbers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        uniqueNumbers.add(num);
                    }
                }
            }
        }
        for (int num : uniqueNumbers) {
            System.out.print(num + " ");
        }

    }

    //question 31
    static void questionThirtyOne(int[] arr) {
        int i = 0;
        while (i < arr.length/2) {
            swap(arr, i, arr.length-1-i);
            i++;
        }
    }
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    static int[][] questionThirtyTwo(int[][] arr, int[][] arr1) {
        int[][] ans = new int[arr.length][];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = arr[i][j] + arr1[i][j];
            }
        }
        return ans;
    }

    static String[] questionThirtyThree(String s){
        int v = 0;
        int c = 0;
        String t = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if(t.contains(s.charAt(i)+"")) {
                v++;
            } else {
                if(s.charAt(i) != ' ')
                    c++;
            }
        }
        return new String[] {"Vovels : ", v+" ", "Consonants : ", c+"" };
    }

    static boolean questionThirtySeven(int n) {
        String t = String.valueOf(n); //typecasting int to string for getting the length
        int ans = 0;
        int len = t.length();
        for (int i = 0; i < t.length(); i++) { //looping for each element
            ans += (int)Math.pow((t.charAt(i)-48), len); // typecasting and adding with the power of the length
        }
        return ans == n; //returning if true or false;
    }

    static double questionThirtyEight(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    static void questionForty(int n) {
        //m1
        int a = 0, b = 1;
        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }




}
