class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[2][prices.length+1];
        for(int idx = prices.length-1; idx >= 0; idx--){
            int buy = -prices[idx] - fee + dp[0][idx+1];
            int skip = dp[1][idx+1];
            dp[1][idx] = Math.max(buy,skip);


            int sell = prices[idx] + dp[1][idx+1];
            int hold = dp[0][idx+1];
            dp[0][idx] = Math.max(sell, hold);

        }
        return dp[1][0];
    }
    // public int helper(int prices[], int idx, int fee, int canBuy, int dp[][]){
    //     if(idx == prices.length){
    //         return 0;
    //     }
    //     if(dp[canBuy][idx] != Integer.MIN_VALUE){
    //         return dp[canBuy][idx];
    //     }
    //     if(canBuy == 1){
    //         int buy = -prices[idx] - fee + helper(prices, idx+1, fee, 0, dp);
    //         int skip = helper(prices, idx+1, fee, 1, dp);
    //         dp[canBuy][idx] = Math.max(buy,skip);
    //         return dp[canBuy][idx];
    //     }
    //     else{
    //         int sell = prices[idx] + helper(prices, idx+1, fee, 1, dp);
    //         int hold = helper(prices, idx+1, fee, 0, dp);
    //         dp[canBuy][idx] = Math.max(sell, hold);
    //         return dp[canBuy][idx];
    //     }
    //}
}