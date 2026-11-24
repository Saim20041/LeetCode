class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int product = nums[i];
            int gcd = nums[i];
            int lcm = nums[i];
            for(int j = i+1; j < nums.length; j++){
                product*=nums[j];
                gcd = gcdCalculator(gcd, nums[j]);
                lcm = lcm/gcdCalculator(lcm,nums[j])*nums[j];
                if(product == lcm*gcd){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    private int gcdCalculator(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }
}