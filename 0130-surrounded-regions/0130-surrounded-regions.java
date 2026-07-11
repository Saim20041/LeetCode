class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                helper(0, i, board);
            }
            if(board[board.length-1][i] == 'O'){
                helper(board.length-1, i, board);
            }
        }
        for(int i = 1; i < board.length - 1; i++){
            if(board[i][0] == 'O'){
                helper(i, 0, board);
            }
            if(board[i][board[0].length-1] == 'O'){
                helper(i, board[0].length-1, board);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'C'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
            
    }
    public void helper(int i, int j, char board[][]){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'C';
        helper(i, j-1, board);
        helper(i, j+1, board);
        helper(i-1, j, board);
        helper(i+1, j, board);
        return;
        
    }
}