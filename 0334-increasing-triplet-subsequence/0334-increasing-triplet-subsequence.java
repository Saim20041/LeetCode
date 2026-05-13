class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for(int n: nums){
            if(num1 > n){
                num1 = n;
            }
            else if(num2 > n && n > num1){
                num2 = n;
            }
            else if(n > num1 && n > num2) return true;
        }
        return false;
    }
}