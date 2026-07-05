class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        int curr;
        for(int i = 0; i < temps.length; i++){
            while(!stack.isEmpty() && temps[i] > temps[stack.peek()]){
                results[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return results;
    }
}