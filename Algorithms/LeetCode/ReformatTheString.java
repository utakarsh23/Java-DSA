package LeetCode;

import java.util.Stack;

class ReformatTheString {
    public String reformat(String s) {
        if (s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        Stack<Character> letters = new Stack<>();
        Stack<Character> digits = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            } else {
                digits.push(ch);
            }
        }

        if (Math.abs(digits.size() - letters.size()) > 1) 
            return "";

        while (!letters.isEmpty() && !digits.isEmpty()) {
            sb.append(letters.pop()).append(digits.pop());
        }

        if (!letters.isEmpty())
            sb.append(letters.pop());
        else if (!digits.isEmpty())
            sb.insert(0, digits.pop());

        return sb.toString();
    }
}