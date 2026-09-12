class Solution {

    private boolean verifyCols(char[][] board, int R, int C) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < C; ++i) {
            for (int j = 0; j < R; ++j) {
                if (board[j][i] == '.')
                    continue;
                if (!set.add(board[j][i]))
                    return false;
            }
            set.clear();
        }

        return true;
    }

    private boolean verifyRows(char[][] board, int R, int C) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!set.add(board[i][j]))
                    return false;
            }
            set.clear();
        }

        return true;
    }

    private boolean verifyGrid(char[][] board, int rs, int re, int cs, int ce) {
        Set<Character> set = new HashSet<>();

        for (int i = rs; i < re; ++i)
            for (int j = cs; j < ce; ++j)
                if (board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int R = board.length, C = board[0].length;

        boolean rowValid = verifyRows(board, R, C);
        boolean colValid = verifyCols(board, R, C);
        boolean gridValid = 
           verifyGrid(board, 0, 3, 0, 3)
        && verifyGrid(board, 0, 3, 3, 6)
        && verifyGrid(board, 0, 3, 6, 9)
        && verifyGrid(board, 3, 6, 0, 3)
        && verifyGrid(board, 3, 6, 3, 6)
        && verifyGrid(board, 3, 6, 6, 9)
        && verifyGrid(board, 6, 9, 0, 3)
        && verifyGrid(board, 6, 9, 3, 6)
        && verifyGrid(board, 6, 9, 6, 9);

        return rowValid && colValid && gridValid;
        
    }
}
