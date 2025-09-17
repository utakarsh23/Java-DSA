package LeetCode;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int cap = 0;
        int low = 0;
        char l1 = word.charAt(0);
        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                low++;
            } else if(Character.isUpperCase(c)) {
                cap++;
            }
        }
        if(cap >0 && low == 0) return true;
        if(low >0 && cap == 0) return true;
        if(cap == 1 && Character.isUpperCase(l1)) return true;
        return false;
    }
}
