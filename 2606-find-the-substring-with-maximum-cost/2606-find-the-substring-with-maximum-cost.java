class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++){
            map.put(chars.charAt(i), vals[i]);
        }
        int arr[] = new int[s.length()];
        for(int i = 0; i < arr.length; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                arr[i] = map.get(ch);
            }
            else{
                arr[i] = 1 + (int) (ch - 'a');
            }
        }
        int max = 0;
        int curr = 0;
        for(int i = 0; i < arr.length; i++){
            curr+=arr[i];
            if(curr<0){
                curr=0;
            }
            max = Math.max(curr,max);
        }
        return max;

    }
    
}