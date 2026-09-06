class Solution {

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][][] dp = new int[k + 1][m][n][5];
        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[t][i][j], -1);
                }
            }
        }
        int res = helper(k, 0, 0, -1, grid, dp);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
    public int helper(int k, int i, int j, int direction,
                      int[][] grid, int[][][][] dp) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            k < 0) {

            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 &&
            j == grid[0].length - 1) {

            return grid[i][j];
        }
        int dirIndex = direction == -1 ? 4 : direction;
        if (dp[k][i][j][dirIndex] != -1) {
            return dp[k][i][j][dirIndex];
        }
        int up;
        int down;
        int left;
        int right;
        if (direction == 0 || direction == -1) {
            up = helper(k, i - 1, j, 0, grid, dp);
        } else {
            up = helper(k - 1, i - 1, j, 0, grid, dp);
        }
        if (direction == 1 || direction == -1) {
            down = helper(k, i + 1, j, 1, grid, dp);
        } else {
            down = helper(k - 1, i + 1, j, 1, grid, dp);
        }
        if (direction == 2 || direction == -1) {
            left = helper(k, i, j - 1, 2, grid, dp);
        } else {
            left = helper(k - 1, i, j - 1, 2, grid, dp);
        }
        if (direction == 3 || direction == -1) {
            right = helper(k, i, j + 1, 3, grid, dp);
        } else {
            right = helper(k - 1, i, j + 1, 3, grid, dp);
        }
        int best = Math.min(
            up,
            Math.min(down, Math.min(left, right))
        );
        if (best == Integer.MAX_VALUE) {
            dp[k][i][j][dirIndex] = Integer.MAX_VALUE;
        } else {
            dp[k][i][j][dirIndex] = grid[i][j] + best;
        }

        return dp[k][i][j][dirIndex];
    }
}