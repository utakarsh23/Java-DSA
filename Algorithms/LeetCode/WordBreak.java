package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        System.out.println(wordBreak("bb", List.of("a","b","bbb","bbbb")));
        System.out.println(primesTillN(9));
    }
    static public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        int index = -1;
        for(String t : wordDict) {
            index = sb.indexOf(t);
            if(index >= 0) {
                sb.replace(index, index + t.length(), "");
            } else {
                return false;
            }
        }
        return true;
    }


    static boolean primesTillN(int x) {
        for (int i = 3; i < Math.sqrt(x); i+= 2) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
