class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        int res = helper(0, n-1, piles, dp);
        return res > 0;

    }
    private int helper(int i, int j, int piles[], int dp[][]){
        if(i>j){
            return 0;
        }
        if(i == j){
            return piles[i];
        }
        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }
        int pickLeft = piles[i] - helper(i+1, j, piles, dp);
        int pickRight = piles[j] - helper(i, j-1, piles, dp);
        dp[i][j] = Math.max(pickLeft, pickRight);
        return dp[i][j];
    }
}