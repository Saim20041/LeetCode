class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int score1 = helper(0, n-1, nums);
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        int score2 = sum - score1;
        return score1 >= score2;
    }
    private int helper(int i, int j, int nums[]){
        if(i > j) return 0;
        if(i == j){
            return nums[i];
        }
        int choosei = nums[i] + Math.min(helper(i+2, j, nums), helper(i+1, j-1, nums));
        int choosej = nums[j] + Math.min(helper(i, j-2, nums), helper(i+1, j-1, nums));
        return Math.max(choosei, choosej);
    }
}