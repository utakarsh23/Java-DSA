package LeetCode;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
    static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<String> wordList = new ArrayList<>(map.keySet());

        // 3. Sort the list based on frequency (descending), and lexicographically (ascending)
        Collections.sort(wordList, (a, b) -> {
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });

        // 4. Return top k elements
        return wordList.subList(0, k);
    }
}
