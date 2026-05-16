class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0; 
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < min) min = nums[mid];
            
            if(nums[right] < nums[mid]) left = mid + 1;
            else if(nums[right] > nums[mid]) right = mid;
            else right--;
            
        }  
        return min;  
    }
}