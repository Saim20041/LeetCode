class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += helper(s, i, i, dp);
        }

        return count;
    }

    public int helper(String s, int left, int right, Boolean[][] dp) {

        if (right == s.length()) {
            return 0;
        }

        int count = 0;

        if (isPalindrome(s, left, right, dp)) {
            count = 1;
        }

        return count + helper(s, left, right + 1, dp);
    }

    public boolean isPalindrome(
        String s,
        int left,
        int right,
        Boolean[][] dp
    ) {

        if (left >= right) {
            return true;
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        if (s.charAt(left) != s.charAt(right)) {
            return dp[left][right] = false;
        }

        return dp[left][right] =
            isPalindrome(s, left + 1, right - 1, dp);
    }
}