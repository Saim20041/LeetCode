class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int dp[][] = new int[s.length()][s.length()];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        for(int i = s.length()-1; i >= 0; i--){
            count+=helper(s, i, i, dp);
        }
        return count;
    }
    public int helper(String s, int left, int right, int dp[][]){
        if(right == s.length()){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        if(isPalindrome(s, left, right)){
            dp[left][right] = 1 + helper(s, left, right+1, dp);
            return dp[left][right];
        }
        else{
            dp[left][right] = helper(s, left, right+1, dp);
            return dp[left][right];
        }


    }
    public boolean isPalindrome(String s, int left, int right){
        if(left < 0 || right >= s.length()){
            return false;
        }
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}