class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m*n];
        int index = 0;
        int count = 0;
        
        int remainder = grid[0][0] % x;
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j]%x != remainder) return -1;
                arr[index] = grid[i][j];
                
                index++;
          
            }
        }    
        Arrays.sort(arr);
        
        int element = arr[(m*n)/2];
        for(int i = 0; i < arr.length; i++){
            count += Math.abs((element - arr[i])/x);
        }
        return count;


    }
}