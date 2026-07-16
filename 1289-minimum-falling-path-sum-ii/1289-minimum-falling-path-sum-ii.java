class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        int index1 = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
            if(smallest >= dp[0][i]){
                secSmallest = smallest;
                ;
                smallest = dp[0][i];
                index1 = i;
            }
            else if(secSmallest > dp[0][i]){
                secSmallest = dp[0][i];                
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j != index1){
                    dp[i][j] = Math.min(smallest + grid[i][j], dp[i][j]);
                }
                else{
                    dp[i][j] = Math.min(secSmallest + grid[i][j], dp[i][j]);
                }
            }
            smallest = Integer.MAX_VALUE;
            secSmallest = smallest;
            for(int k = 0; k < n; k++){
                if(smallest >= dp[i][k]){
                secSmallest = smallest;                
                smallest = dp[i][k];
                index1 = k;
            }
                else if(secSmallest > dp[i][k]){
                    secSmallest = dp[i][k];                
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < res) {
                res = dp[n - 1][i];
            }
        }
        return res;
    }
}