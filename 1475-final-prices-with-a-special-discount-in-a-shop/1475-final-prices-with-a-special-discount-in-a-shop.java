class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = prices.length-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i] = prices[i];
            }
            else{
                arr[i] = prices[i] - stack.peek();
            }
            stack.push(prices[i]);
        }
        return arr;
    }
}