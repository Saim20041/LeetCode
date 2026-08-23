class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][] = new int[4][obstacles.length];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return sideJump(2, 0, obstacles, dp);
    }
    public int sideJump(int curr, int idx, int obstacles[], int dp[][]){
        if(idx == obstacles.length-1){
            return 0;
        }
        if(dp[curr][idx] != -1){
            return dp[curr][idx];
        }
        if(obstacles[idx+1] == curr){
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= 3; i++){
                if(i == curr || obstacles[idx] == i){
                    continue;
                }
                
                min = Math.min(min, 1+sideJump(i, idx+1, obstacles, dp));
            }
            dp[curr][idx] = min;
            return dp[curr][idx];
        }
        dp[curr][idx] = sideJump(curr, idx+1, obstacles,dp);
        return dp[curr][idx];
        


    }
}