package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class CheckifStringIsPanagram {
    public static void main(String[] args) {

    }
    public boolean checkIfPangram(String sentence) {
        // Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }
}
