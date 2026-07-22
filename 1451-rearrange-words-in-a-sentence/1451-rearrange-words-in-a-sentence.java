class Solution {
    public String arrangeWords(String text) {
        String arr[] = text.split(" ");
        arr[0] = arr[0].toLowerCase();
        List<String> bucket[] = new ArrayList[text.length() + 1];
        for(String word : arr){
            int len = word.length();
            if(bucket[len] == null){
                bucket[len] = new ArrayList<>();
            }
            bucket[len].add(word);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(bucket[i] == null) continue;
            for(String word : bucket[i]){
                sb.append(word).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();

        

    }
}