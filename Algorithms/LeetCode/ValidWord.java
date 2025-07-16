package LeetCode;

public class ValidWord {
    public static void main(String[] args) {
        System.out.println(isValid("aya"));
    }
    static public boolean isValid(String word) {
        if(word.contains("@") || word.contains("#") || word.contains("$")) {
            return false;
        }
        String vovels = "aeiouAEIOU";
        boolean ch = false;
        boolean ch1 = false;
        boolean ch3 = false;
        for(char w : word.toCharArray()) {
            if((int) w >= 65 && (int) w <= 90 && !ch) {
                ch = true;
            }
            if((int) w >= 97 && (int) w <= 122 && !ch1) {
                ch1 = true;
            }
            if(vovels.contains(w+"") && !ch3) {
                ch3 = true;
            }
        }
        return (ch || ch1) && ch3;
    }
    public boolean isValid1(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;

            if (isVowel(ch)) {
                hasVowel = true;
            } else if (Character.isLetter(ch)) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
