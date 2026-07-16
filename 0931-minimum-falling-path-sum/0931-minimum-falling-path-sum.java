class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row, Integer.MAX_VALUE/2);
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + matrix[i][j]);
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + matrix[i][j]);
                }
                if(j < n-1){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + matrix[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(dp[n-1][i] < res){
                res = dp[n-1][i];
            }
        }
        return res;
    }
}