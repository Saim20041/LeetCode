class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        for(int i = 0; i < 2; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return helper(0, 1, prices, dp);

    }
    public int helper(int idx, int canBuy, int prices[], int dp[][]){
        if(idx >= prices.length){
            return 0;
        }
        if(dp[canBuy][idx] != Integer.MIN_VALUE){
            return dp[canBuy][idx];
        }
        if(canBuy == 1){
            int buy = -prices[idx] + helper(idx+1, 0, prices, dp);
            int dont = helper(idx+1, 1, prices, dp);
            dp[canBuy][idx] = Math.max(buy, dont);
            return dp[canBuy][idx];
        }
        else{
            int sell = prices[idx] + helper(idx+2, 1, prices, dp);
            int hold = helper(idx+1, 0, prices, dp);
            dp[canBuy][idx] = Math.max(sell, hold);
            return dp[canBuy][idx];
        }
    }
}