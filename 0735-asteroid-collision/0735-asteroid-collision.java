class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids){
            // if(stack.isEmpty()){
            //     stack.push(asteroid);
            //     continue;
            // }
            boolean survive = true;
            
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if(Math.abs(asteroid) == stack.peek()){
                    stack.pop();
                    survive = false;
                    break;
                }
                else if(Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                }
                else{
                    survive = false;
                    break;
                }
            }
            if(survive){
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int res[] = new int[size];
        for(int i = size-1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}