class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int negativeCounter = n/2;
        int positiveCounter = n-negativeCounter;
        long add = 0;
        long sub = 0;
        while(left <= right && positiveCounter > 0){
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                add+=nums[left] * nums[left];
                positiveCounter--;
                left++;
            }
            else{
                add+=nums[right] * nums[right];
                positiveCounter--;
                right--;
            }
        }
        while(negativeCounter!=0){
            sub+=nums[left]*nums[left];
            left++;
            negativeCounter--;
        }
        return add-sub;
    }
}