class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return helper(n-1, n, costs, dp);
    }
    public int helper(int idx, int n, int cost[], int dp[]){
        
        if(n <= 0){
            return 0;
        }

        if(dp[n] != Integer.MIN_VALUE){
            return dp[n];
        }        

        int case1 = cost[idx] + 1 + helper(idx-1, n-1, cost, dp);
        int case2 = cost[idx] + 4 + helper(idx-2, n-2, cost, dp);
        int case3 = cost[idx] + 9 + helper(idx-3, n-3, cost, dp);

        dp[n] = Math.min(Math.min(case1, case2), case3);

        return dp[n];
    }
}