class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int n = str1.length();
        int m = str2.length();
        while(m != 0){
            int temp = m;
            m = n % m;
            n = temp;
        }
        return str1.substring(0,n);
    }
}