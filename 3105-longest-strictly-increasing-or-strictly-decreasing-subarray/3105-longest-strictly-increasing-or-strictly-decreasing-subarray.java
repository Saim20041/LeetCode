class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int max = 1;
        int dec = 1;
        int inc = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                dec+=1;
                max = Math.max(max, dec);
            }
            else{
                dec=1;
            }
            if(nums[i] < nums[i+1]){
                inc+=1;
                max = Math.max(max, inc);
            }
            else{
                inc=1;
            }

        }
        return max;
    }
}