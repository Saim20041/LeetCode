class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < word1.length() && ptr2 < word2.length()){
            sb.append(word1.charAt(ptr1));
            sb.append(word2.charAt(ptr2));
            ptr1++;
            ptr2++;
        }
        if(ptr1 < word1.length()){
            sb.append(word1.substring(ptr1, word1.length()));
        }
        else if(ptr2 < word2.length()){
            sb.append(word2.substring(ptr2, word2.length()));
        }
        return sb.toString();
    }
}