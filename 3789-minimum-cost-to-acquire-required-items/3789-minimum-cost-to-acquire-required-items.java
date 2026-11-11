class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalCost = 0;
        if(need1 > 0 && need2 > 0){
            if(cost1 + cost2 >= costBoth){
                int buy = Math.min(need1, need2); 
                totalCost+= 1L * buy * costBoth;
                need1-=buy;
                need2-=buy;   
            }
            else{
                int buy = Math.min(need1,need2);
                totalCost += 1L * (cost1+cost2) * buy;
                need1-=buy;
                need2-=buy;
            }
        }
        if(need1 > 0){
            totalCost+=1L * Math.min(cost1, costBoth) * need1;
        }
        if(need2 > 0){
            totalCost+=1L * Math.min(cost2, costBoth) * need2;
        }
        return totalCost;
    }
}