package Randoms;

import java.util.ArrayList;
import java.util.List;

public class subs {

    private static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(subsets(0, 3));
        System.out.println(lists);
    }

    static List<Integer> subsets(int n, int k) {
        if(n == k) {
            return new ArrayList<>();
        }
        List<Integer> l1 = new ArrayList<>();
        l1.add(n);
        lists.add(subsets(n+1, k));

        return l1;
    }
}
