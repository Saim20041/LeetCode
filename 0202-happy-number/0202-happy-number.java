class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        seen.add(n);
        while(true){
            int curr = helper(n);
            if(curr == 1){
                return true;
            }
            else{
                if(seen.contains(curr)){
                    return false;
                }
                seen.add(curr);
            }
            n = curr;
        }
     
    }
    public int helper(int n){
        int temp = 0;
        while(n!=0){
            int curr = 0;
            curr = n%10;
            n/=10;
            temp+=curr * curr;
        }
        return temp;
    }
}