package IntroductoryProblems;

import java.util.HashMap;
import java.util.Map;

public class Repetitions {
    public static void main(String[] args) {
        System.out.println(repetitions1("ATTCGGGA"));
    }

    static int repetitions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int max = 0;
        for (char c : map.keySet()) {
            max = Math.max(max, map.get(c));
        }
        return max;
    }

    static int repetitions1(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[(int)s.charAt(i)-65]++;
        }
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

}
