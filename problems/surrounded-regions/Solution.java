public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '.';
            }
            if (board[i][m - 1] == 'O') {
                board[i][m - 1] = '.';
            }
        }
        for (int j = 1; j < m - 1; j++) {
            upAndDown(board, j, n);
        }
        for (int j = m - 2; j > 0; j--) {
            upAndDown(board, j, n);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '.';
            }
            if (board[n - 1][j] == 'O') {
                board[n - 1][j] = '.';
            }
        }
        for (int i = 1; i < n - 1; i++) {
            leftAndRight(board, i, m);
        }
        for (int i = n - 2; i > 0; i--) {
            leftAndRight(board, i, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void upAndDown(char[][] board, int j, int n) {
        if (board[0][j - 1] == '.' && board[0][j] == 'O')
            board[0][j] = '.';
        for (int i = 1; i < n; i++) {
            if (board[i][j] != 'O')
                continue;
            if (board[i - 1][j] == '.')
                board[i][j] = '.';
            else if (board[i][j - 1] == '.')
                board[i][j] = '.';
            else if (board[i][j + 1] == '.')
                board[i][j] = '.';
        }
        for (int i = n - 2; i >= 0; i--) {
            if (board[i][j] != 'O')
                continue;
            if (board[i + 1][j] == '.')
                board[i][j] = '.';
        }
    }
    
    private void leftAndRight(char[][] board, int i, int m) {
        if (board[i - 1][0] == '.' && board[i][0] == 'O')
            board[i][0] = '.';
        for (int j = 1; j < m; j++) {
            if (board[i][j] != 'O')
                continue;
            if (board[i][j - 1] == '.')
                board[i][j] = '.';
            else if (board[i - 1][j] == '.')
                board[i][j] = '.';
            else if (board[i + 1][j] == '.')
                board[i][j] = '.';
        }
        for (int j = m - 2; j >= 0; j--) {
            if (board[i][j] != 'O')
                continue;
            if (board[i][j + 1] == '.')
                board[i][j] = '.';
        }
    }
}