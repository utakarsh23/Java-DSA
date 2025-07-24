import java.util.Arrays;
import java.util.Scanner;

public class ExpOne {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        System.out.println(sumOfEven(n));
//        System.out.println(maxOFThree(9, 11, 6));
        System.out.println(armstrong(156));
    }

    static int sumOfEven(int n) {
        int count = 0; //count od prime
        int sum = 0; //sum
        int i = 0; //iteration for prime checking
        while (count < n) { //while loop for prime upto n
            if((i & 1) == 0) { //even
                if(i % 3 == 0) //div by 3
                    sum += i; //adding in sum
                count++; //incrementing even count
            }
            i++; //incrementing iterator
        }
        return sum; //returning the value
    }



    static String findPerimeter() {
        Scanner input = new Scanner(System.in); //taking input
        int radius = input.nextInt(); //input as int
        if(radius < 0) { //edge case
            return "Invalid Input";
        }
        double pi = Math.PI; //pi
        return "Perimeter : "+  String.valueOf(2 * pi * radius).substring(0, 10) + "\nArea : " + String.valueOf(pi * Math.pow(radius, 2)).substring(0, 10); //returning the values with upto 10 digits
    }


    //post labs
    //1
    static int maxOFThree(int a, int b, int c) {
        if(a > b && b > c) {
            return a;
        } else if (b > a && c < b) {
            return b;
        }
        return c;
    }

    //2
    static boolean armstrong(int n) {
        String t = String.valueOf(n); //typecasting int to string for getting the length
        int ans = 0;
        int len = t.length();
        for (int i = 0; i < t.length(); i++) { //looping for each element
            ans += (int)Math.pow((t.charAt(i)-48), len); // typecasting and adding with the power of the length
        }
        return ans == n; //returning if true or false;
    }

}
