class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++){
            map.put(chars.charAt(i), vals[i]);
        }
        int max = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int cost = map.containsKey(ch) ? map.get(ch) : 1 + (int) (ch - 'a');
            curr+=cost;
            if(curr<0){
                curr=0;
            }
            max = Math.max(curr,max);
        }
        return max;

    }
    
}