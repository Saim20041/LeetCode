class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            int start = l[i];
            int end = r[i];
            int curr[] = new int[end-start+1];
            int insert = 0;
            for(int j = start; j <= end; j++){
                curr[insert] = nums[j];
                insert++;
            }
            Arrays.sort(curr);
            int diff = curr[1] - curr[0];
            for(int k = 1; k < curr.length; k++){
                if(curr[k] - curr[k-1] != diff){
                    list.add(false);
                    break;
                }
                else if(k == curr.length-1){
                    list.add(true);
                }
            }
            
            
        }    
        return list;
    }
}