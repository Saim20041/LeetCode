class Solution {
    public long maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int num : nums){
            if(Math.abs(num) >= max1){
                max2 = max1;
                max1 = Math.abs(num);
            }
            else if(Math.abs(num) > max2){
                max2 = Math.abs(num);
            }
        }
        return 1L*max1*max2*100000;
    }
}