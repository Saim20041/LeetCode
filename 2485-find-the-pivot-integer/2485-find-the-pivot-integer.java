class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum+=i;
        }
        int curr = 0;
        for(int i = 1; i <= n; i++){
            curr+=i;
            if(curr == sum){
                return i;
            }
            sum-=i;
        }
        return -1;
    }
}