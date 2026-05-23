class Solution {
    public boolean check(int[] nums) {
    boolean bool = false;
    for(int i = 0; i < nums.length-1; i++){
        if(bool == false && nums[i] > nums[i+1]){
            bool = true;
        }
        else if(bool == true && nums[i] > nums[i+1]){
            return false;
        }
    }   
    if(bool == true && nums[0] < nums[nums.length-1]){
        return false;
    }
    return true;
    }
}