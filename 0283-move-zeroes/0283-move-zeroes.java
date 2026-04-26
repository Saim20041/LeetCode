class Solution {
    public void moveZeroes(int[] nums) {
        int indexInsert = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[indexInsert] = nums[i];
                indexInsert++;

            }
        } 
        while(indexInsert < nums.length){
            nums[indexInsert] = 0;
            indexInsert++;
        }       
    }
}