package LeetCode;

import java.util.*;

public class SortCharByFreq {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }
//    static public String frequencySort(String s) {
//        char[] ch = s.toCharArray();
//        Arrays.sort(ch);
//        char[] ans = new char[s.length()];
//        int j = 0;
//        StringBuilder sb = new StringBuilder();
//        StringBuilder st = new StringBuilder();
//        boolean isAdded = true;
//        for (char c : ch) {
//            if (sb.indexOf(c + "") > -1) {
//                st.append(c);
//                if (isAdded) {
//                    ans[j++] = c;
//                }
//                isAdded = false;
//                ans[j++] = c;
//            } else {
//                if (st.indexOf(c + "") < 0) {
//                    isAdded = true;
//                }
//                sb.append(c);
//            }
//        }
//        for (char c : ch) {
//            if (st.indexOf(c + "") < 0) {
//                ans[j++] = c;
//            }
//        }
//        return new String(ans);
//    }

    static public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] arr = new char[s.length()];
        int j = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                arr[j--] = s.charAt(i);
                map.remove(s.charAt(i));
            }
        }
        List<List<Integer>> li = new ArrayList<>();
        for (char c : map.keySet()) {
            ArrayList<Integer> lis = new ArrayList<>();
            lis.add(map.get(c));
            lis.add((int) c);
            li.add(lis);
        }
        int k = 0;
        int y = 0;
        li.sort((a, b) -> Integer.compare(b.get(0), a.get(0)));
        while (y < li.size() && !li.isEmpty()) {
            for (int i = 0; i < li.get(y).getFirst(); i++) {
                arr[k++] = (char)li.get(y).get(1).intValue();
            }
            y++;
        }
        return new String(arr);
    }
}
