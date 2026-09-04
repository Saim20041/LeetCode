class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];
        int currMax = nums[0];
        int currMin = nums[n-1];
        for(int i = 0; i < n; i++){
            if(nums[i] > currMax){
                currMax = nums[i];
            }
            if(nums[n-1-i] < currMin){
                currMin = nums[n-1-i];
            }
            max[i] = currMax;
            min[n-1-i] = currMin;
        }
        for(int i = 0; i < n; i++){
            if(max[i] - min[i] <= k){
                return i;
            }
        }
        return -1;
    }
}