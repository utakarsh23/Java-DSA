package LeetCode;

public class Base7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
    static String convertToBase7(int n) {
        // return Integer.toString(num, 7);
        int temp = n;
        if(n == 0) return "0";

        n = Math.abs(n);
        String digits = "0123456789";
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, digits.charAt(n % 7));
            n /= 7;
        }
        if(temp < 0) return "-"+sb.toString();
        return sb.toString();
    }
}
