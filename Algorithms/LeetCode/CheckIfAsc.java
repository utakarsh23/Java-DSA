package LeetCode;

import java.util.ArrayList;

class checkIfAsc {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(areNumbersAscending(s));
    }
    static boolean areNumbersAscending(String s) {
        int i = 0;
        ArrayList<Integer> li = new ArrayList<>();
        while(i < s.length()) {
            if(!(Character.isDigit(s.charAt(i)))) {
                i++;
                continue;
            } else {
                int sum = 0;
                while(i < s.length() && s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <= 9) {
                    int ss = (s.charAt(i)-'0');
                    sum = sum*10 + ss;
                    i++;
                }
                li.add(sum);
            }
            i++;
        }
        for(int j = 1; j < li.size(); j++) {
            if(!(li.get(j-1) < li.get(j))) {
                return false;
            }
        }
        return true;
    }
}