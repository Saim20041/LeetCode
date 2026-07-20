class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m*n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[index++] = grid[i][j];
            }
        }
        k = k % (m*n);
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        index = 0;
        for(int i = 0; i < m; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j < n; j++){
                curr.add(arr[index++]);
                
            }
            list.add(curr);
        }
    return list;    
    }
    private void reverse(int arr[], int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return;
    }
    
}