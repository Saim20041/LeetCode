class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            
            int sum = 0;
        
            while(num != 0){
                int temp = num%10;
                num/=10;
                sum+=temp; 
            }               
            
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
}