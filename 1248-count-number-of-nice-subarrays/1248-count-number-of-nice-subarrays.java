class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int curr = 0;
        int even = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 == 1){
                curr++;
                even = 0; // new odd resets extra even count
            }

            while(curr == k && left <= right){
                even++;
                if(nums[left] % 2 == 1){
                    curr--;
                }
                left++;
            }

            count += even;
        }

        return count;
    }
}