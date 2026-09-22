class Solution {
    int offset = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        int dp[][] = new int[nums.length+1][sum*2+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        offset = sum;
        return helper(nums, target, 0, dp);
    }
    public int helper(int nums[], int target, int idx, int dp[][]){
        if (target < -offset || target > offset) {
            return 0;
        }
        if(target == 0 && idx == nums.length){
            return 1;
        }
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][target+offset] != -1){
            return dp[idx][target+offset];
        }
        int positive = helper(nums, target-nums[idx], idx+1, dp);
        int negative = helper(nums, target+nums[idx], idx+1, dp);
        dp[idx][target+offset] = positive + negative;
        return dp[idx][target+offset];
    }
}