package GFG;

class longestSubstringWithoutRepeatingChar {
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
}