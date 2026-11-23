class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<=2){
            return -1;
        }
        int arr[] = new int[]{nums[0], nums[1], nums[2]};
        Arrays.sort(arr);
        return arr[1];

        
    }
}