package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    //   0   1   2   3   4    5    6   7   8   9   10  11  12
    // "10","6","9","3","+","-11","*","/","*","17","+","5","+"

    //   0   1   2     3    4    5    6   7   8   9   10  11  12
    // "10","6","12","-11","*","/","*","17","+","5","+"

    //   0   1     2    3   4    5   6   7   8   9   10  11  12
    // "10","6","-132","/","*","17","+","5","+"

    // 0   1   2    3    4  6  6   7   8  9  10
    // 10  6  12  (-11)  *  /  *   17  +  5   +

    // 10  6  -132  /  *  17  +  5  +
    //  0  1    2   3  4   5  6  7  8

    // 10  0  *  17  +  5  +
    //  0  1  2   3  4  5  6

    // 0  17  +  5  +
    // 0  1   2  3  4

    // 17  5  +
    // 0   1  2

    // 22
    // 0



    static public int evalRPN(String[] tokens) {
        int len = tokens.length;
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        int ti = 0;
        for(int i = 0; i < list.size(); i++){
            ti = i;
            if(list.get(i).equals("+")) {
                ti = i-2;
                int a = Integer.parseInt(list.get(i-1));
                int b = Integer.parseInt(list.get(i-2));
                list.remove(i-2);
                list.remove(i-2);
                list.remove(i-2);
                list.add(i-2, String.valueOf(a+b));
            } else if(list.get(i).equals("-")) {
                ti = i-2;
                int a = Integer.parseInt(list.get(i-1));
                int b = Integer.parseInt(list.get(i-2));
                list.remove(i-2);
                list.remove(i-2);
                list.remove(i-2);
                list.add(i-2, String.valueOf(b-a));
            } else if(list.get(i).equals("*")) {
                ti = i-2;
                int a = Integer.parseInt(list.get(i-1));
                int b = Integer.parseInt(list.get(i-2));
                list.remove(i-2);
                list.remove(i-2);
                list.remove(i-2);
                list.add(i-2, String.valueOf(a*b));
            } else if(list.get(i).equals("/")) {
                ti = i-2;
                int a = Integer.parseInt(list.get(i-1));
                int b = Integer.parseInt(list.get(i-2));
                list.remove(i-2);
                list.remove(i-2);
                list.remove(i-2);
                list.add(i-2, String.valueOf(b/a));
            }
            i = ti;
        }
        return Integer.parseInt(list.get(0));
    }

    //m2
    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            switch(s) {
                case "+" -> {
                    int x = stack.pop() + stack.pop();
                    stack.push(x);
                }
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
                case "*" -> {
                    int x = stack.pop() * stack.pop();
                    stack.push(x);
                }
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
                default -> stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
