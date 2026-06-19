class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0; i < gain.length; i++){
            curr+=gain[i];
            max = Math.max(curr,max);
        }    
        if(max < 0) return 0;
        return max;
    }
}