class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((m+n)%2 == 0){
            return false;
        }

        Boolean dp[][][] = new Boolean[m][n][(m+n)/2+1];

        return helper(0, 0, grid, 0, dp);
    }

    public boolean helper(int i, int j, char grid[][], int open, Boolean dp[][][]) {

        if(i >= grid.length || j >= grid[0].length){
            return false;
        }

        if(grid[i][j] == '('){
            open++;
        }
        else{
            open--;
        }

        if(open < 0){
            return false;
        }

        if(open >= dp[0][0].length){
            return false;
        }

        int remaining = (grid.length - 1 - i) + (grid[0].length - 1 - j);

        if(open > remaining){
            return false;
        }

        if(i == grid.length-1 && j == grid[0].length-1){
            return open == 0;
        }

        if(dp[i][j][open] != null){
            return dp[i][j][open];
        }

        boolean case1 = helper(i+1, j, grid, open, dp);
        boolean case2 = helper(i, j+1, grid, open, dp);

        dp[i][j][open] = case1 || case2;

        return dp[i][j][open];
    }
}