class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(0, i, j, board, word, visited)) {
                        return true;
                    }
                    for(boolean curr[] : visited){
                        Arrays.fill(curr, false);
                    }

                }
            }
        }
        return false;
    }

    public boolean dfs(int idx, int i, int j, char[][] board, String word, boolean visited[][]) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (idx == word.length() -1 && word.charAt(idx) == board[i][j]) {
            return true;
        }
        if (word.charAt(idx) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if(
            dfs(idx + 1, i + 1, j, board, word, visited) ||
            dfs(idx + 1, i, j + 1, board, word, visited) ||
            dfs(idx + 1, i - 1, j, board, word, visited) ||
            dfs(idx + 1, i, j - 1, board, word, visited)
        ){
            return true;
        }
         
        visited[i][j] = false;
        return false;
    }
}