class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int count[] = new int[100001];
        int barCount = 0;
        for(int i = 0; i < n; i++){
            count[costs[i]]++;
        }
        for(int i = 1; i < count.length; i++){
            if(count[i] == 0){
                continue;
            }
            
            while(count[i]>0){
                if(coins < i){
                    return barCount;
                }
                coins -= i;
                count[i]--;
                barCount++;
            }
        }
        return barCount;

    }
}