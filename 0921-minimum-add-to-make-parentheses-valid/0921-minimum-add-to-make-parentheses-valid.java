class Solution {
    public int minAddToMakeValid(String s) {
        int total = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) == ')'){
                    total++;
                }
                else{
                    stack.push('(');
                }
            }
            else if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                stack.pop();
            }

        }
        total+= stack.size();
        return total;
    }
}