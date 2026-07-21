class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }
    public void helper(int candidates[], int target, int idx, int curr, List<Integer> ans){
        if(idx>=candidates.length) return;
        if(curr == target){
            result.add(new ArrayList<>(ans));
            return;
        }
        else if(curr>target) return;
        
        ans.add(candidates[idx]);
        curr+= candidates[idx];
        helper(candidates, target, idx, curr, ans);
       
        ans.remove(ans.size()-1);
        curr-=candidates[idx];
        helper(candidates, target, idx+1, curr, ans);
        
        
    }
}