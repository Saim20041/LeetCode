class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder(s);
        int arr[] = new int[s.length()+1];
        for(int i = 0; i < shifts.length; i++){
            int start = shifts[i][0];
            int end = shifts[i][1]+1;
            int direction = shifts[i][2];
            if(direction == 0){
                arr[start]--;
                arr[end]++;
            }
            else{
                arr[start]++;
                arr[end]--;
            }
        }
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i] + arr[i-1];
        }    
        for(int i = 0; i < s.length(); i++){
            char ch = sb.charAt(i);
            int index = ch - 'a';
            index = ((index + arr[i])%26 + 26) % 26;
            ch = (char) (index + 'a');
            sb.setCharAt(i, ch);
        }
        s = sb.toString();
        return s;
            
            
    }
    
}
