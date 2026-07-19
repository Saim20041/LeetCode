class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        boolean visited[] = new boolean[26];
        StringBuilder sb = new StringBuilder();
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(visited[ch - 'a'] == true){
                freq[ch - 'a']--;
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek() - 'a'] > 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
            freq[ch - 'a']--;
        }
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}