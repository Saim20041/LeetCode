
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(result,0,nums);
    return result;

    }
    public void helper(List<List<Integer>> result,int index, int nums[]){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);    
            }
            result.add(list);

            return;
        }
        
        for(int i = index; i < nums.length; i++){
            
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            helper(result,index + 1,nums);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            
        }
       
    }
}