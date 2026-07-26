class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount+1][coins.length];
        for(int row[] : dp){
            Arrays.fill(row ,-1);
        }
        return helper(amount, coins.length-1, coins, dp);
    }
    private int helper(int amount, int index, int coins[], int dp[][]){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(index < 0){
            return 0;
        }
        if(dp[amount][index] != -1){
            return dp[amount][index];
        }
        int case1 = helper(amount - coins[index], index, coins, dp);
        int case2 = helper(amount, index-1, coins, dp);
        dp[amount][index] = case1 + case2;
        return dp[amount][index];
        
        
    }
}