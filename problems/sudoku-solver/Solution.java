public class Solution {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] wins = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] <= '9' && board[i][j] >'0') {
                    int val = board[i][j] - '0';
                    int bin = (1 << val);
                    rows[i] |= bin;
                    cols[j] |= bin;
                    wins[i / 3 * 3 + j / 3] |= bin;
                }
            }
        }
        solve(board, rows, cols, wins, 0, 0);
    }
    
    private boolean solve(char[][] board, int[] rows, int[] cols, int[] wins, int ii, int jj) {
        int i = ii;
        int j = jj;
        while (board[i][j] != '.') {
            j++;
            if (j == 9) {
                i++;
                j = 0;
            }
            if (i == 9)
                return true;
        }
        int win = i / 3 * 3 + j / 3;
        for (char c = '1'; c <= '9'; c++) {
            int k = c - '0';
            int bin = (1 << k);
            if ((rows[i] & bin) != 0)
                continue;
            if ((cols[j] & bin) != 0)
                continue;
            if ((wins[win] & bin) != 0)
                continue;
            board[i][j] = c;
            rows[i] |= bin;
            cols[j] |= bin;
            wins[win] |= bin;
            boolean res = solve(board, rows, cols, wins, i, j);
            if (res)
                return true;
            board[i][j] = '.';
            rows[i] &= ~bin;
            cols[j] &= ~bin;
            wins[win] &= ~bin;
        }
        return false;
    }
}