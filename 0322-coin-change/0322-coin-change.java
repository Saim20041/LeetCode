class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[amount+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        int res = helper(coins, amount, n-1, dp);
        return res == Integer.MAX_VALUE ? -1:res;
    }
    private int helper(int coins[], int amount, int index, int dp[][]){
        if(amount <= 0 || index<0){
            if(amount == 0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(dp[amount][index] != -1){
            return dp[amount][index];
        }
        int noPick = helper(coins, amount, index-1,dp);
        int pick = Integer.MAX_VALUE;
        pick = helper(coins, amount - coins[index], index, dp);
        if(pick != Integer.MAX_VALUE){
            pick++;
        }
        dp[amount][index] = Math.min(pick,noPick);
        return Math.min(pick,noPick);
    }
    
}