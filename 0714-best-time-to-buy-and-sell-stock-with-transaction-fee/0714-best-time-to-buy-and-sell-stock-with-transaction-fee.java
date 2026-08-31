class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[2][prices.length];
        for(int i = 0; i < 2; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return helper(prices, 0, fee, 1, dp);
    }
    public int helper(int prices[], int idx, int fee, int canBuy, int dp[][]){
        if(idx == prices.length){
            return 0;
        }
        if(dp[canBuy][idx] != Integer.MIN_VALUE){
            return dp[canBuy][idx];
        }
        if(canBuy == 1){
            int buy = -prices[idx] - fee + helper(prices, idx+1, fee, 0, dp);
            int skip = helper(prices, idx+1, fee, 1, dp);
            dp[canBuy][idx] = Math.max(buy,skip);
            return dp[canBuy][idx];
        }
        else{
            int sell = prices[idx] + helper(prices, idx+1, fee, 1, dp);
            int hold = helper(prices, idx+1, fee, 0, dp);
            dp[canBuy][idx] = Math.max(sell, hold);
            return dp[canBuy][idx];
        }
    }
}