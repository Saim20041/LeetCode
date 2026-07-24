class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Boolean dp[][] = new Boolean[nums.length+1][target+1];
        return helper(0, target, nums, dp);

    }

    public boolean helper(int index, int target, int nums[], Boolean dp[][]) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (index == nums.length) {
            return false;
        }
        if(dp[index][target] != null){
            return dp[index][target];
        }
        boolean case1 = helper(index + 1, target, nums, dp);
        boolean case2 = helper(index + 1, target - nums[index], nums, dp);
        dp[index][target] = case1 || case2;
        return dp[index][target];
    }
}