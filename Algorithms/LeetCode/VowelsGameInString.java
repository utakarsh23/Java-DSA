package LeetCode;

public class VowelsGameInString {
    public boolean doesAliceWin(String s) {
        int no = 0;
        String vov = "aeiou";
        for(int i = 0; i < s.length(); i++) {
            if(vov.contains(s.charAt(i)+"")) {
                no++;
            }
        }
        if(no == 0) {
            return false;
        } else if(no%2 != 0) {
            return true;
        } else {
            if(no - 3 > 0) {
                return true;
            } else {
                return true;
            }
        }
    }
}
