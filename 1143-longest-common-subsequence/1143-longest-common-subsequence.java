class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(text1,text2,n-1,m-1,dp);
    }
    public int helper(String t1, String t2, int n, int m, int[][] dp){
        if(n < 0 || m < 0){
            
            return 0;
        } 
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(t1.charAt(n) == t2.charAt(m)){
            dp[n][m] = 1 + helper(t1,t2,n-1,m-1,dp);
            return dp[n][m];
        }
        
        dp[n][m]=Math.max(helper(t1,t2,n,m-1,dp),helper(t1,t2,n-1,m,dp));

        return dp[n][m];
        
    }
}