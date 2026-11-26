class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb[] = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int currRow = 0;
        int direction = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sb[currRow].append(ch);
            if(direction == 1 && currRow < numRows - 1){
                currRow++;
            }
            else if(direction == -1 && currRow > 0){
                currRow--;
            }
            if(currRow == numRows-1){
                direction= -1;
            }
            else if(currRow == 0){
                direction = 1;
            }
            
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            ans.append(sb[i]);
        }
        return ans.toString();
    }
}