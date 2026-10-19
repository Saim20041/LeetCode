class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int smallerNums = 0;
        int targetCount = 0;
        for(int i : nums){
            if(i < target){
                smallerNums++;
            }
            else if(i == target){
                targetCount++;
            }
        }
        for(int i = 0; i < targetCount; i++){
            list.add(i+smallerNums);
        }
        return list;
    }
}