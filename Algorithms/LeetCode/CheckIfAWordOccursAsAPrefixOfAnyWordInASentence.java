package LeetCode;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {

    }
    static public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split("\\s");
        int i = 1;
        for(String s : arr) {
            if(s.startsWith(searchWord)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
