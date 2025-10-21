package LeetCode;

import java.util.HashMap;
import java.util.Map;

class countWordsInStrings {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        
        for(String word: words2) {
            int existing = map.getOrDefault(word, 0);
            if (map.containsKey(word) && existing < 2) {
                map.put(word, existing - 1);
            }
        }
        
        int c = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 0) c++;
        }
        
        return c;
    }
}