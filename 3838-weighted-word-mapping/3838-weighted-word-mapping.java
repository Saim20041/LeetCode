class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            int sum = 0;
            for(int j = 0; j < str.length(); j++){
                int num = str.charAt(j) - 'a';
                sum+=weights[num];
                
            }
            sum%=26;
            char ch = 'z';
            ch-=sum;
            sb.append(ch);
        }    
        String res = sb.toString();
        return res;
    }
}