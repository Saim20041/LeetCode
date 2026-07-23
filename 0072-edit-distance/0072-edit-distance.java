class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, word1, word2, dp);
    }
    public int helper(int i, int j, String word1, String word2, int dp[][]){
        if(i == word1.length() && j == word2.length()){
            return 0;
        }
        if(i == word1.length()){
            dp[i][j] = word2.length() - j;
            return dp[i][j];
        }
        if(j == word2.length()){
            dp[i][j] = word1.length() - i;
            return dp[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = helper(i+1, j+1, word1, word2, dp);
            return dp[i][j];
        }
        int case1 = 1 + helper(i+1, j+1, word1, word2, dp);  
        int case2 = 1 + helper(i+1, j, word1, word2, dp);     
        int case3 = 1 + helper(i, j+1, word1, word2, dp);    
        dp[i][j] = Math.min(Math.min(case1,case2),case3);
        return dp[i][j];
    }
}