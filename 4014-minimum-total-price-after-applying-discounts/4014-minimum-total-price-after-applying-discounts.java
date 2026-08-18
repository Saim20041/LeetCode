class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int index = discounts.length-1;
        double total = 0;
        for(int i = prices.length-1; i >= 0; i--){
            if(index >= 0){
                total += (double)(prices[i] * (100 - discounts[index]))/100;
                index--;
                
            }
            else{
                total+=prices[i];
            }
        }
        return total;
    }
}