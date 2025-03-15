package Recursion.Strings;

public class reverseString {
    public static void main(String[] args) {
        System.out.println(revStrr("ABC"));
    }

    private static String revStrr(String s) {
        if(s.length() <= 1) {
            return s;
        }
        char firstChar = s.charAt(0);
        String remainingString = s.substring(1);
        return revStrr(remainingString) + firstChar;
    }
}
