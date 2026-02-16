package DP_LC;

class WildcardMatching {
    public boolean isMatch(String s, String p) {
        //intuition -> try all possibilities.
        // int i = s.length();
        // int j = p.length();

        // Boolean[][] dp = new Boolean[i+1][j+1];
        // dp[0][0] = true;
        // return helperDP1(s, p, i, j, dp);

        return helperTabulation(s, p);
    }

    private boolean helper(String s, String p, int i, int j) {
        if(i < 0 && j < 0) return true;
        //match found, both equal

        //exhausted all a, and b left
        if(i < 0 && j >= 0) {
            //checking if b only have '*' so we can turn it to ''.
            //if possible then answer is yes else no.
            while(j >= 0 && p.charAt(j) == '*') j--;
            if(j == -1) return true;
            else return false;
        }

        if(j < 0 && i >= 0) return false;


        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return helper(s, p, i-1, j-1);
        if(p.charAt(j) == '*') return helper(s, p, i, j-1) || helper(s, p, i-1, j);

        return false;
    }


        //faulty
        private boolean helperDP(String s, String p, int i, int j, boolean[][] dp) {
        if(i <= 0 && j <= 0) return true;
        //match found, both equal

        //exhausted all a, and b left
        if(i <= 0 && j > 0) {
            //checking if b only have '*' so we can turn it to ''.
            //if possible then answer is yes else no.
            while(j-1 >= 0 && p.charAt(j-1) == '*') j--;
            if(j-1 == -1) return true;
            else return false;
        }

        if(j <= 0 && i > 0) return false;
        if(dp[i][j]) return dp[i][j];


        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') return dp[i][j] = helperDP(s, p, i-1, j-1, dp);
        if(p.charAt(j-1) == '*') return dp[i][j] = helperDP(s, p, i, j-1, dp) || helperDP(s, p, i-1, j, dp);

        return dp[i][j] = false;
    }

    private boolean helperDP1(String s, String p, int i, int j, Boolean[][] dp) {
        if(i == 0 && j == 0) return true;

        if(j == 0) return false;

        if(i == 0 && j > 0) {
            while(j > 0 && p.charAt(j-1) == '*') {
                j--;
            }
            if(j == 0) return true;
            else return false;
        }
        if(dp[i][j] != null) return dp[i][j];

        boolean ans;
        if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) ans = helperDP1(s, p, i-1, j-1, dp);
        else if(p.charAt(j-1) == '*') ans = helperDP1(s, p, i-1, j, dp) || helperDP1(s, p, i, j-1, dp);
        else ans = false;

        return dp[i][j] = ans;

    } 


    private boolean helperTabulation(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        //base case 
        for(int i = 1; i <= n; i++) {
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }


        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                boolean ans = false;
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    ans = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    ans = dp[i-1][j] || dp[i][j-1];
                } 
                dp[i][j] = ans;
            }
        }

        return dp[m][n];
    }
}