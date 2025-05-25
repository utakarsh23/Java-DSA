package LeetCode;

import java.util.HashSet;

class longestSubstringWithoutRepeatingChar {

    //m1 - gfg
    public int longestUniqueSubstr(String s) {
        // code here
        int res = 0;
        boolean[] bs = new boolean[26];
        
        int left = 0, right = 0;
        while(right < s.length()) {
            while(bs[s.charAt(right) - 'a'] == true) {
                bs[s.charAt(left)-'a'] = false;
                left++;
            }
            
            bs[s.charAt(right)-'a'] = true;
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }

    //m2
    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}