class Solution {
    public int numDistinct(String s, String t) {
        
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, s, t, dp);
    }
    public int helper(int i, int j, String s, String t, int dp[][]){
        if(j == t.length()){
            dp[i][j] = 1;
            return dp[i][j];
        }
        if(i == s.length()){
            dp[i][j] = 0;
            return dp[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            int case1 = helper(i+1, j+1, s, t, dp);
            int case2 = helper(i+1, j, s, t, dp);
            dp[i][j] = case1+case2;
            return dp[i][j];
        }
        dp[i][j] = helper(i+1, j, s, t, dp);
        return dp[i][j];
    }

}