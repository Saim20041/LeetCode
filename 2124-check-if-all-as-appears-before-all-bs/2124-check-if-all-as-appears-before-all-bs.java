class Solution {
    public boolean checkString(String s) {
        boolean bool = false;
        for(int i = 0 ; i < s.length(); i++){
            if(bool == false && s.charAt(i) == 'b'){
                bool = true;
            }
            else if(s.charAt(i)=='a' && bool == true){
                return false;
            }
        }    
        return true;
    }
}