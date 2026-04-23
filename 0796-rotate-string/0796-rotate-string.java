class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String str3 = s + s;
        if(str3.contains(goal)){
            return true;
        }    
        return false;
    }
}