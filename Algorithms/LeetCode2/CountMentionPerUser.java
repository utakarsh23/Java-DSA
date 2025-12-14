package LeetCode2;

import java.util.*;

public class CountMentionPerUser {
    public static void main(String[] args) {
        List<List<String>> events = List.of(List.of("MESSAGE","10","id1 id0"), List.of("OFFLINE","11","0"), List.of("MESSAGE","71","HERE"), List.of("OFFLINE","37","0"));
        System.out.println(Arrays.toString(new CountMentionPerUser().countMentions(2, events)));
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            Map<String, Set<Integer>> map = new HashMap<>();
            for (List<String> ls : events) {
                String[] listIdss = ls.get(2).split("\\s+");
                int ln = listIdss.length;
                if(!ls.get(0).equals("OFFLINE")) continue;
                for (int i = 0; i < ln; i++) {
                    int a = Integer.parseInt(ls.get(1));
                    for (String l : listIdss) {
                        putInMap(map, l, a);
                    }
                }
            }

            int[] ans = new int[numberOfUsers];

            for(List<String> ls : events) {
                checkInMap(map, ans, Integer.parseInt(ls.get(1)));
            }

            return new int[]{};


        }

        private void checkInMap(Map < String, Set < Integer >> map, int[] ans, int time) {
            for (int i = 0; i < ans.length; i++) {
                ++ans[i];
            }

            for(String s : map.keySet()) {
                int ck = parse(s);
                if(map.containsKey(s))
                    if(map.get(s).contains(time)) {
                        ans[ck]--;
                    }
            }
        }

        private int parse(String c) {
            return c.charAt(c.length()-1)-'0';
        }

        private void putInMap (Map < String, Set < Integer >> map, String key, int val){
            Set<Integer> set = new HashSet<>();
            int[] ars = new int[60];
            for (int i = val; i <= val + 60; i++) {
                set.add(i);
            }
            if (map.containsKey(key)) {
                map.get(key).addAll(set);
            } else {
                map.put(key, set);
            }
        }
}
