package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequence {
    public static void main(String[] args) {
        System.out.println(new NumberOfMatchingSubsequence().numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
    }

        public int numMatchingSubseq(String s, String[] words) {
            Map<Character, List<Integer>> map = new HashMap<>();
            int i = 0;
            for(char c : s.toCharArray()) {
                if(!map.containsKey(c)) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i++);
                    map.put(c, arr);
                } else {
                    map.get(c).add(i++);
                }
            }

            int ans = 0;
            for(String word : words) {
                int lastInd = -1;
                int wl = word.length();
                int j = 0;
                for(char c : word.toCharArray()) {
                    if(map.containsKey(c)) {
                        List<Integer> arr = map.get(c);
                        int bsa = binarySearchIndexCeil(arr, lastInd); //must return the real index of the char found.
                        if(bsa == -1) continue;
                        lastInd = bsa;
                        if(++j == wl) ans++;
                    } else {
                        continue;
                    }
                }
            }
            return ans;
        }

        private int binarySearchIndexCeil(List<Integer> list, int targetIndex) {
            int n = list.size();
            if(n == 1) {
                return list.getFirst() > targetIndex ? list.getFirst() : -1;
            }
            int start = 0;
            int end = n;
            while(start <= end) {
                int mid = start + (end - start)/2;
                if(list.get(mid) > targetIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start < n ? list.get(start) : -1;
        }

        //map -> integer : list
        //searchCeilBinary(arr, tar); : return int;





        // abcde
        // a -> [0]
        // b -> [1]
        // c -> [2]
        // d -> [3]
        // e -> [4]


        // dsahjpjauf -> ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"] : ahjpjau
        // d -> [0]
        // s -> [1]
        // a -> [2, 7]
        // h -> [3]
        // j -> [4, 6]
        // p -> [5]
        // u -> [8]
        // f -> [9]


        // ahjpjau
        // a -> 2, h -> 3, j -> 4, p -> 5, j -> 6, a -> 7, u -> 8

        // ja
        // j -> 4, a -> 7

        // ahbwzgqnuk
        // a -> 2, h -> 3, b -> XXXXX

        // tnmlanowax
        // t -> XXXXX

    }