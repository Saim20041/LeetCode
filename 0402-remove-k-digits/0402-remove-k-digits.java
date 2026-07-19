class Solution {
    public String removeKdigits(String num, int k) {
        int curr = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && curr < k && stack.peek() > ch) {
                stack.pop();
                curr++;
            }
            stack.push(ch);
        }
        while (curr < k) {
            stack.pop();
            curr++;
        }

        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for (char ch : stack) {
            if (ch == '0' && check == false) {
                continue;
            } else {
                check = true;
            }
            sb.append(ch);
        }

        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }
}