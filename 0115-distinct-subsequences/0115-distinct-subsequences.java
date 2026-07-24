class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][n] = 1;
        }
        for(int i = m-1; i >=0; i--){
            for(int j = n-1; j >=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    int case1 = dp[i+1][j+1];
                    int case2 = dp[i+1][j];
                    dp[i][j] = case1+case2;
                    
                }
                else{
                    dp[i][j] = dp[i+1][j];
                    
                }
            }
        }
        return dp[0][0];
    }
}