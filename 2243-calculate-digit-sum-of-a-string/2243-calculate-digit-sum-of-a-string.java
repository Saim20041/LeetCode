class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k){
            s = helper(s, k);
        }
        return s;
    }
    public String helper(String s, int k){
        int sum = 0;
        int curr = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int num = (int) (s.charAt(i) - '0');
            sum += num;
            curr++;
            if(curr == k){
                sb.append(String.valueOf(sum));
                sum = 0;
                curr = 0;
            }
            if(i == s.length()-1 && curr > 0){
                sb.append(String.valueOf(sum));
            }
        }
        
        return sb.toString();
    }
}