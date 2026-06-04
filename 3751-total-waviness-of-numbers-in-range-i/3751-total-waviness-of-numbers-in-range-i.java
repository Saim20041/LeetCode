class Solution {
    public int totalWaviness(int num1, int num2) {
        int peak = 0;
        int valley = 0;
        for(int i = num1; i <= num2; i++){
            String s = String.valueOf(i);
            for(int j = 1; j < s.length()-1; j++){
                int digit1 = s.charAt(j-1) - '0';
                int digit2 = s.charAt(j+1) - '0';
                int digit3 = s.charAt(j) - '0';
                if(digit1 > digit3 && digit3 < digit2){
                    valley++;
                }
                else if(digit1 < digit3 && digit3> digit2){
                    peak++;
                }
            }    
        }
        return peak+valley;    
    }
}