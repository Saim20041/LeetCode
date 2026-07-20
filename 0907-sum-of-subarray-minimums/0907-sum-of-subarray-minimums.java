class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int nextSmallest[] = new int[n];
        int prevSmallest[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextSmallest[i] = stack.peek();
            }
            else{
                nextSmallest[i] = n;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                prevSmallest[i] = stack.peek();
            }
            else{
                prevSmallest[i] = -1;
            }
            stack.push(i);
        }
        long ans = 0;
        int mod = 1_000_000_007;
        for(int i = 0; i < n; i++){
            int left = i - prevSmallest[i];
            int right = nextSmallest[i] - i;
            long contribution = (left * right)%mod;
            ans += ((arr[i] % mod) * (contribution%mod)) % mod;
            ans%=mod;
        }
        
        return (int)ans;

    }
}