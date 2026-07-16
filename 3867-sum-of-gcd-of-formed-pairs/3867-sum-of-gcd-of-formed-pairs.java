class Solution {
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int prefixGcd[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefixGcd[i] = calculate(max, nums[i]);
        }    
        Arrays.sort(prefixGcd);
        // for(int i = 0, j = prefixGcd.length-1; i < j ; i++, j--){ 
        //     int temp = prefixGcd[i];
        //     prefixGcd[i] = prefixGcd[j];
        //     prefixGcd[j] = temp;
        // }
        // i realise there is no need to do that(decending order)
        long sum = 0;
        for(int i = 0, j = prefixGcd.length-1; i < j; i++, j--){
            sum += calculate(prefixGcd[i], prefixGcd[j]);
        }
        return sum;

    }
    private int calculate(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}