class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    // private int helper(int n, int dp[]){
    //     if(n <=2){
    //         return n;
    //     }
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
    //     dp[n] = helper(n-1, dp) + helper(n-2,dp);
    //     return dp[n];
    // }
    
}