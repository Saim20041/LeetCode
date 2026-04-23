class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            // check if target can be in this row
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {

                int left = 0;
                int right = n - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (matrix[i][mid] == target) return true;
                    else if (target > matrix[i][mid]) left = mid + 1;
                    else right = mid - 1;
                }

                return false;
            }
        }
        return false;
    }
}