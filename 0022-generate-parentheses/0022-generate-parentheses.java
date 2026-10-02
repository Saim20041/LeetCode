class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, "", ans);
        return ans;
    }
    public void helper(int open, int close, int n, String s, List<String> ans){
        if(open == n && close == n){
            ans.add(s);
            return;
        }
        if(open < n){
            helper(open+1, close, n, s + "(", ans);
        }
        if(close < open){
            helper(open, close+1, n, s + ")", ans);
        }
        
    }
}