package Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ran {
    static String a = "all the the best";
    static String b = "all thebest";
    public static void main(String[] args) {
        System.out.println(a.indexOf("the"));
        System.out.println(b.indexOf("the"));
        System.out.println(a.contains("the"));
        System.out.println(b.contains("the"));
        Set<String> ste = new HashSet<>(Arrays.stream(a.split("\\s+")).toList());
        System.out.println(ste.contains("the"));
        Set<String> stes = new HashSet<>(Arrays.stream(b.split("\\s+")).toList());
        System.out.println(stes.contains("the"));
        System.out.println(ste);

        String[] arr = a.split("\\s+");
        List<String> list = Arrays.stream(a.split("\\s+")).toList();

    }
}
