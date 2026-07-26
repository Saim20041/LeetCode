class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int num : nums){
            currMax+=num;
            max = Math.max(max, currMax);
            if(currMax < 0){
                currMax = 0;
            }
            total+=num;
        }
        if (max < 0) {
            return max;
        }
        int currMin = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            currMin+=num;
            min = (Math.min(min, currMin));
            if(currMin > 0){
                currMin = 0;
            }
        }
        return Math.max(max, total - min);
    }
}