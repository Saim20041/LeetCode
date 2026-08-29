class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length+1][m+1][n+1];
        for(int x[][] : dp){
            for(int y[] : x){
                Arrays.fill(y, -1);
            }
        }
        return helper(strs, m, n, 0, dp);
    }

    public int helper(String[] strs, int m, int n, int idx, int dp[][][]) {

        if(idx == strs.length) {
            return 0;
        }
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }

        int zeroes = 0;
        int ones = 0;

        String curr = strs[idx];

        for(int i = 0; i < curr.length(); i++) {
            if(curr.charAt(i) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }

        // Don't take current string
        int notTake = helper(strs, m, n, idx + 1, dp);

        // Take current string only if it fits
        int take = 0;

        if(zeroes <= m && ones <= n) {
            take = 1 + helper(
                strs,
                m - zeroes,
                n - ones,
                idx + 1,
                dp
            );
        }
        dp[idx][m][n] = Math.max(take, notTake);;
        return dp[idx][m][n];
    }
}