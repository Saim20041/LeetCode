class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n, k, target, dp);
    }

    public int helper(int n, int k, int target, int dp[][]){
        if(n == 0){
            return target == 0? 1: 0;
        }
        if(target < 0){
            return 0;
        }
        if(dp[n][target] != -1) {
            return dp[n][target];
        }
        int ways = 0;
        for(int face = 1; face <= k; face++){           
            ways+=helper(n-1, k, target - face, dp);
            ways%=1_000_000_007;
        }
        dp[n][target] = ways;
        return ways;
    }
}