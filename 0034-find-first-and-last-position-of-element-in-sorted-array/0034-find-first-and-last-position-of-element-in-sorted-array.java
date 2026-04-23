class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if(nums.length == 0){
            return new int[] {-1,-1};
        }
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                break;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(nums[mid] != target){
            return new int[] {-1,-1};
        }  
        left = mid;
        right = mid;
        while(left >= 0 && nums[left] == target){
            left--;
        }      
        while(right < nums.length && nums[right] == target){
            right++;
        }
        return new int[] {left+1,right-1};

    }
}