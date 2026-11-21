class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i = 1; i < strs.length; i++){
            String curr = strs[i];
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(j < Math.min(common.length(), curr.length())){
                if(common.charAt(j) == curr.charAt(j)){
                    sb.append(common.charAt(j));
                }
                else{
                    break;
                }
                j++;
            }
            common = sb.toString();
        }
        return common;
    }
}