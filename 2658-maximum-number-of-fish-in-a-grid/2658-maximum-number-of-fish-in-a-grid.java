class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] > 0) {
                    max = Math.max(max, helper(i, j, grid));

                }

            }
        }
        return max;
    }

    public int helper(int i, int j, int grid[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int fish = grid[i][j];
        grid[i][j] = 0;
        fish += helper(i + 1, j, grid);
        fish += helper(i, j + 1, grid);
        fish += helper(i, j - 1, grid);
        fish += helper(i - 1, j, grid);

        return fish;
    }
}