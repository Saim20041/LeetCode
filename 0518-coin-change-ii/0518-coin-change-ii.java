class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount + 1][coins.length];
        for (int j = 0; j < coins.length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i][j] += dp[i - coins[j]][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[amount][coins.length - 1];
    }
}