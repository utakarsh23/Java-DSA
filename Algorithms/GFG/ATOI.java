package GFG;

public class ATOI {
    public static void main(String[] args) {
        String s = "-123";
        System.out.println(myAtoi1(s));
    }
    static int myAtoi(String s) {
        // Your code here
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1, index = 0;
        long result = 0;

        if(s.charAt(index) == '+' || Character.isDigit(s.charAt(index))) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while(index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index)-'0';
            result = result * 10 + digit;

            if(result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if(result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int)(result*sign);
    }

    static int myAtoi1(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1;
        int index = 0;
        long result = 0;

        // Handle sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // Process digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;

            // Check for overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int)(result * sign);
    }
}
