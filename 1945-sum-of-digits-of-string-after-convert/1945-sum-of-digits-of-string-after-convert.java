class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - 'a' + 1;
            while(num > 0){
                sum+=num%10;
                num/=10;
            }
     
        } 
        if(k == 1) return sum;
        k = k-1;
        for(int i = 0; i < k; i++){
            int curr = 0;
            while(sum > 0){
                curr += sum%10;
                sum /= 10;
            }
            sum = curr;
        }
        return sum;
   

    }
}