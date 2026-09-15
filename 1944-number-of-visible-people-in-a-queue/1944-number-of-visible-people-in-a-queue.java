class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res[] = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--){
            if(stack.isEmpty()){
                res[i] = 0;
                stack.push(heights[i]);
                continue;
            }
            if(heights[i] > stack.peek()){
                int count = 0;
                while(!stack.isEmpty() && heights[i] > stack.peek()){
                    count++;
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = count;
                }
                else{
                    res[i] = count+1;
                }
                stack.push(heights[i]);
                continue;
                
            }
            if(heights[i] <= stack.peek()){
                res[i] = 1;
                stack.push(heights[i]);
                
            }
            

            
        } 
        return res;
    }
}