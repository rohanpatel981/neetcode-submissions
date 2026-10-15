class Solution {
    private void explore(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            board[i][j] != 'O')
            return;
        
        board[i][j] = '#';
        explore(board, i, j - 1);
        explore(board, i + 1, j);
        explore(board, i - 1, j);
        explore(board, i, j + 1);
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            explore(board, i, 0);
            explore(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; ++i) {
            explore(board, 0, i);
            explore(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }
}
