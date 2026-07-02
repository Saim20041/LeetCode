class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return (helper(nums, goal) - helper(nums, goal-1)); 
    }
    private int helper(int nums[], int goal){
        if(goal < 0) return 0;
        int curr = 0;
        int left = 0;
        int res = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 1){
                curr++;
            }
            
            while(curr > goal && left <= right){
                if(nums[left] == 1){
                    curr--;
                }
                left++;
            }
            res+=right-left+1;
        }    
        return res;
    }
}