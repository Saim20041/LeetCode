class Solution {
    
    public int[] shortestToChar(String s, char c) {
        
        int result[] = new int[s.length()];
        int first = 0;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                first = i;
                break;
            }
        }    
        for(int i = first+1; i < s.length(); i++){
            if(s.charAt(i) == c){
                second = i;
                break;
            } 
        }
        for(int i = 0; i < result.length; i++){
            if(i == second){
                first = second;
                second = Integer.MAX_VALUE;
                for(int j = first+1; j < s.length(); j++){
                    if(s.charAt(j) == c){
                        second = j;
                        break;
                    }
                }
            }
            result[i] = Math.min(Math.abs(first - i), Math.abs(second-i));

        }
        return result;

    }
}