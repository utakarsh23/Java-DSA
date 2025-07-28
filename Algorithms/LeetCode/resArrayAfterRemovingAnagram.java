package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class resArrayAfterRemovingAnagram {
    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
    }
    static public List<String> removeAnagrams(String[] words) {
        String[] temp = Arrays.copyOf(words, words.length);
        int i = 0;
        for(String s : words) {
            char[] r = s.toCharArray();
            Arrays.sort(r);
            words[i] = new String(r);
            i++;
        }
        for (int j = 1; j < words.length; j++) {
            if(words[j].equals(words[j-1])) {
                words[j-1] = "";
            }
        }
        rev(words);
        rev(temp);
        List<String> li = new ArrayList<>();
        for (int j = words.length-1; j >= 0; j++) {
            if(!words[j].isEmpty()) {
                li.add(temp[j]);
            }
        }
        return li;
    }
    static void rev(String[] t) {
        for (int i = 0; i < t.length / 2; i++) {
            String temp = t[i];
            t[i] = t[t.length-1-i];
            t[t.length-1-i] = temp;
        }
    }
}
