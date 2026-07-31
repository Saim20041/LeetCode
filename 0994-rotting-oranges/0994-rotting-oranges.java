class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if(count == 0){
            return 0;
        }
        int time = 0;
        int dir[][] = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr[] = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for(int direction[] : dir){
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        count--;
                        queue.offer(new int[]{r,c});
                    }
                
                }
            }
            
            time++;
            if(count == 0){
                break;
            }
            
            
        }
        if(count != 0){
            return -1;
        }
        return time;
        
    }
}