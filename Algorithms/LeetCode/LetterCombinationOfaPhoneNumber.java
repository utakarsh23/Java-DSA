package LeetCode;

import Recursion.Strings.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfaPhoneNumber {
    public static void main(String[] args) {
        String dig = "23";
        System.out.println(letterCombinations(dig));
    }
//    static public List<String> letterCombinations(String up) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(2, "abc");
//        map.put(3, "def");
//        map.put(4, "ghi");
//        map.put(5, "jhl");
//        map.put(6, "mno");
//        map.put(7, "pqrs");
//        map.put(8, "tuv");
//        map.put(9, "wxyz");
//        List<Character> list = new ArrayList<>();
//        for(int i = 0; i < up.length(); i++) {
//            list.add(up.charAt(i));
//        }
//        List<String> li = new ArrayList<>();
//        if(up.length() == 1) {
//            String s = map.get(list.getFirst()-'0');
//            for (int i = 0; i < s.length(); i++) {
//                li.add(s.charAt(i)+"");
//            }
//            return li;
//        }
//        if(up.length() == 2) {
//            String s = map.get(list.getFirst()-'0');
//            String t = map.get(list.get(1)-'0');
//            for (int i = 0; i < s.length(); i++) {
//                li.addAll(comb(s.charAt(i), t));
//            }
//            return li;
//        }
//        return li;
//    }
//    static List<String> comb(char c, String s) {
//        List<String> li = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++) {
//            li.add(c+"" + s.charAt(i));
//        }
//        return li;
//    }

    static public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        int s = digits.indexOf('2');
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl"); // fixed typo
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack("", digits, 0, map, result);
        return result;
    }

    static void backtrack(String combination, String digits, int index, Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            backtrack(combination + c, digits, index + 1, map, result);
        }
    }
}
