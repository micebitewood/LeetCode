public class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty())
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (match(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean match(char[][] board, int i, int j, String word, int pos) {
        if (board[i][j] != word.charAt(pos))
            return false;
        if (pos == word.length() - 1)
            return true;
        char c = board[i][j];
        board[i][j] = '$';
        if (i > 0 && match(board, i - 1, j, word, pos + 1))
            return true;
        else if (i < m - 1 && match(board, i + 1, j, word, pos + 1))
            return true;
        else if (j > 0 && match(board, i, j - 1, word, pos + 1))
            return true;
        else if (j < n - 1 && match(board, i, j + 1, word, pos + 1))
            return true;
        board[i][j] = c;
        return false;
    }
}