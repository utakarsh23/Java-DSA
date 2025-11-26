package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    static  String check = "))))))))";
    public static List<String> generateParenthesis(int n) {
        String s = "";
        List<String> list = helperFunc(s, 0, 0, n);
        return list;
    }


    static List<String> helperFunc(String p, int n, int r, int in) {
        if(r > n) {
            return new ArrayList<>();
        }
        if(n == in) {
            int len = p.length();
            p = p + check.substring(0, Math.abs(2*in-len));
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> left = helperFunc(p+"(", n + 1, r, in);
        List<String> right = helperFunc(p+")", n, r+1, in);
        right.addAll(left);
        return right;
    }
}
