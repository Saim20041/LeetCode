class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        boolean bool = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] && bool == true){
                nums[index] = nums[i];
                bool = false;
                index++;
            }
            else if(nums[i] != nums[i-1]){
                bool = true;
                nums[index] = nums[i];
                index++;
            }
            
        }
        return index;

    }
}