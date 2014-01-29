public class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty())
            return true;
        if (board == null)
            return false;
        m = board.length;
        if (m == 0)
            return false;
        n = board[0].length;
        if (n == 0)
            return false;
        int length = word.length();
        if (m * n < length)
            return false;
        Set<Character> set = new HashSet<Character>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(board[r][c]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (!set.contains(word.charAt(i)))
                return false;
        }
        Set<Long> visited = new HashSet<Long>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (find(board, word.substring(1), row, col, visited))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean find(char[][] board, String word, int r, int c, Set<Long> visited) {
        if (word.isEmpty())
            return true;
        long val = getVal(r, c);
        visited.add(val);
        char ch = word.charAt(0);
        if (r - 1 >= 0) {
            if (ch == board[r - 1][c] && !visited.contains(getVal(r - 1, c)))
                if (find(board, word.substring(1), r - 1, c, visited))
                    return true;
        }
        if (c - 1 >= 0) {
            if (ch == board[r][c - 1] && !visited.contains(getVal(r, c - 1)))
                if (find(board, word.substring(1), r, c - 1, visited))
                    return true;
        }
        if (r + 1 < m) {
            if (ch == board[r + 1][c] && !visited.contains(getVal(r + 1, c)))
                if (find(board, word.substring(1), r + 1, c, visited))
                    return true;
        }
        if (c + 1 < n) {
            if (ch == board[r][c + 1] && !visited.contains(getVal(r, c + 1)))
                if (find(board, word.substring(1), r, c + 1, visited))
                    return true;
        }
        visited.remove(val);
        return false;
    }
    
    private long getVal(int r, int c) {
        long val = r;
        val = val * n + c;
        return val;
    }
}