package LeetCode;

public class ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        System.out.println(processStr1("a#b%*", 1));
    }
    static public char processStr(String s, long k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            while (i < s.length() && s.charAt(i) == '*') {
                if(!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                i++;
            } while (i < s.length() && s.charAt(i) == '#') {
                i++;
                String ss = sb.toString();
                sb.append(ss);
            }
            while (i < s.length() && s.charAt(i) == '%') {
                i++;
                sb.reverse();
            }
            while (i < s.length() && s.charAt(i) >= 97 && s.charAt(i) <= 122){
                sb.append(s.charAt(i));
                i++;
            }
        }
        char c = '.';
        if(sb.length() > k) {
            c = sb.toString().toCharArray()[(int) k];
        }
        return c;
    }

    public static char processStr1(String s, long k) {
        long len = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) len++;
            else if (c == '*' && len > 0) len--;
            else if (c == '#') len *= 2;
        }
        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                if (k == len - 1) return c;
                len--;
            } else if (c == '*') {
                len++;
            } else if (c == '#') {
                len /= 2;
                if (k >= len) k -= len;
            } else if (c == '%') {
                k = len - 1 - k;
            }
        }
        return '.';
    }
}
