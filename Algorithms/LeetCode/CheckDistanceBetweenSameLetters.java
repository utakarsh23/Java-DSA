package LeetCode;

import java.util.*;

public class CheckDistanceBetweenSameLetters {
    public static void main(String[] args) {
        System.out.println(checkDistances2("rryzglzgyl", new int[] {1,9,22,36,3,20,2,42,47,5,35,3,11,37,14,37,44,0,15,9,19,44,16,32,5,2}));
    }
    static public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                arr[k++] = i-map.get(c)-1;
            } else {
                map.put(c, i);
            }
        }
        return true;
    }

    static public boolean checkDistances1(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int[] arr = new int[26];
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && !set.contains(s.charAt(i))) {
                int x = map.get(s.charAt(i))-i-1;
                arr[s.charAt(i)-'a'] = x;
                max = Math.max(max, s.charAt(i)-'a');
            }
            set.add(s.charAt(i));
        }
        for (int i = 0; i < max; i++) {
            if(arr[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }

    static public boolean checkDistances2(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // if (!map.containsKey(s.charAt(i))) {
            map.put(s.charAt(i), i);
            // }
        }
        int[] arr = Arrays.copyOf(distance, distance.length);
//        int[] arr = new int[26];
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && !set.contains(c)) {
                arr[c - 'a'] = map.get(c)-i - 1;
                max = Math.max(max, c - 'a');
                set.add(c);
            }
        }

        for (int i = 0; i <= max; i++) {
            if (arr[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }
}
