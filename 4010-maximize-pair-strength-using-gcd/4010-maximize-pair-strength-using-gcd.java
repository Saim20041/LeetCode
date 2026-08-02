class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                
                int a = nums[i];
                int b = nums[j];
                while(b != 0){
                    int temp = b;
                    b = a % b;
                    a = temp;
                    
                }
                long curr = (1L * nums[i] * nums[j])/(1L*a*a);
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}