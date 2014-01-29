public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] wins = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] <= '9' && board[i][j] > '0') {
                    int val = board[i][j] - '0';
                    int bin = (1 << val);
                    if ((rows[i] & bin) != 0)
                        return false;
                    if ((cols[j] & bin) != 0)
                        return false;
                    if ((wins[i / 3 * 3 + j / 3] & bin) != 0)
                        return false;
                    rows[i] |= bin;
                    cols[j] |= bin;
                    wins[i / 3 * 3 + j / 3] |= bin;
                }
            }
        }
        return true;
    }
}