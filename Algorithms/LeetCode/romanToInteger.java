package LeetCode;

import java.util.Map;

class romanToInteger {
    public int romanToInt(String s) {
        int val = 0;
        int lastDigVal = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char romanDig = s.charAt(i);
            int digValue = valuesOfRoman.get(romanDig);
            if(digValue >= lastDigVal) {
                val += digValue;
                lastDigVal = digValue;
            } else {
                val -= digValue;
            }
        }
        return val;
    }

    public Map<Character, Integer> valuesOfRoman = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
}