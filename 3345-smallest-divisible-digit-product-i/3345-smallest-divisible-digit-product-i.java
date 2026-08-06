class Solution {
    public int smallestNumber(int n, int t) {
        int multiple = 1;
        for(int i = n; i < n+10; i++){
            multiple = 1;
            int curr = i;
            while(curr != 0){
                multiple*= curr%10;
                curr = curr/10;
            }
            if(multiple % t == 0){
                return i;
            }
        }
        return 0;
        
    }
}