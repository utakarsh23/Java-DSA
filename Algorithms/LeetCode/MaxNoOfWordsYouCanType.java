package LeetCode;

public class MaxNoOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        char[] cs = brokenLetters.toCharArray();
        for(String t : text.split("\\s+")) {
            int i = 0;
            for(char c : cs) {
                if(t.indexOf(c) >= 0) {
                    i++;
                }
            }
            if(i == 0) {
                ans++;
            }
        }
        return ans;
    }
}
