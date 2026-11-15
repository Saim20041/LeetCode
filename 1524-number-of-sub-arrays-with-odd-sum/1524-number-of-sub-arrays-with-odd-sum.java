class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1_000_000_007;

        long sum = 0;
        long even = 1;
        long odd = 0;
        long total = 0;
        for(int num : arr){
            
            sum+=num;
            if(sum % 2 == 0){
                total = (total + odd) % MOD;
                even++;
            }
            else{
                total = (total + even) % MOD;
                odd++;
            }
        }
        return (int) total%MOD;
    }
}