package IntroductoryProblems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permutations(5));
    }
    static String permutations(int n) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            even.append(i % 2 == 0? i : ""); 
            odd.append(i % 2 != 0? i : "");
        }
        return even.toString()+odd.toString();
    }


    static int fact(int n) {
        if(n == 1) return 1;
        return fact(n -1) + fact(n - 2);
    }
}
