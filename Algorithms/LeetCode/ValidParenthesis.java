package LeetCode;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> ch = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                ch.push(')');
             else if(c == '[')
                ch.push(']');
             else if(c == '{')
                ch.push('}');
             else if (ch.isEmpty() || ch.pop() != c)
                return false;
        }
        return ch.isEmpty();
    }
}
