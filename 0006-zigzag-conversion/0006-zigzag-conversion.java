class Solution {
    public String convert(String s, int numRows) {
        char grid[][] = new char[1000][1000];

        int currRow = 0;
        boolean direction = true;
        int column = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            grid[currRow][column] = ch;
            if(direction == true && currRow < numRows-1){
                currRow++;
            }
            else if(direction == false && currRow > 0){
                column++;
                currRow--;
            }
            if(currRow == numRows-1){
                direction = false;
                column++;
            }
            else if(currRow == 0){
                direction = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                if(grid[i][j]!='\u0000'){
                    sb.append(grid[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
