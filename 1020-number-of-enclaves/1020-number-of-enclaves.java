class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 
        int count = 0;
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                helper(i,0,grid,m,n);
            }
            if(grid[i][n-1] == 1){
                helper(i,n-1,grid,m,n);
            }
        }
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                helper(0,i,grid,m,n);
            }
            if(grid[m-1][i] == 1){
                helper(m-1,i,grid,m,n);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(int i, int j, int grid[][], int m, int n){
        if(i < 0 || j < 0 || i > m-1 || j > n-1 || grid[i][j]==0){
            return;
        }
        grid[i][j] = 0;
        helper(i -1,j,grid,m,n);
        helper(i +1,j,grid,m,n);
        helper(i,j -1,grid,m,n);
        helper(i,j +1,grid,m,n);
        return;
    }
}
