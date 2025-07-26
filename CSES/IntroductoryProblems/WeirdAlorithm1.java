package IntroductoryProblems;

import java.util.ArrayList;
import java.util.List;

public class WeirdAlorithm1 {
    public static void main(String[] args) {
        System.out.println(weirdAlgorithm(3));
    }
    static List<Integer> weirdAlgorithm(int n) {
        List<Integer> li = new ArrayList<>();
        while (n != 1) {
            li.add(n);
            n = n % 2 == 0 ? n/2 : (n * 3) + 1;
        }
        li.add(1);
        return li;
    }


}
