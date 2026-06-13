class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int rightSum[] = new int[n];
        int leftSum[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=nums[i];
        } 
        int temp = sum;   
        for(int i = 0; i < n; i++){
            rightSum[i] = sum-nums[i];
            sum = sum-nums[i];
        }
        for(int i = n-1; i >= 0; i--){
            leftSum[i] = temp - nums[i];
            temp = temp - nums[i];
        }
        for(int i = 0; i < n; i++){
            leftSum[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return leftSum;
    }
}