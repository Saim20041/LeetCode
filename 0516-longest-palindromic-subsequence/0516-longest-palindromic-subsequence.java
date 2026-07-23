class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[s.length()][r.length()];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, s, r, dp);
    }

    public int helper(int i, int j, String s, String r, int dp[][]) {
        if (i == s.length() || j == r.length()) {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if (s.charAt(i) == r.charAt(j)) {
            dp[i][j] = 1 + helper(i + 1, j + 1, s, r, dp);

            return dp[i][j];
        }

        int case1 = helper(i + 1, j, s, r, dp);
        int case2 = helper(i, j + 1, s, r, dp);
        dp[i][j] = Math.max(case1, case2);
        return dp[i][j];

    }
}