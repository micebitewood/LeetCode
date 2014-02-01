public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                span(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                span(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                span(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                span(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (board[i][j]) {
                    case '.':
                        board[i][j] = 'O';
                        break;
                    case 'O':
                        board[i][j] = 'X';
                }
            }
        }
    }
    
    private void span(char[][] board, int i, int j) {
        board[i][j] = '.';
        String head = getStr(i, j);
        Queue<String> queue = new LinkedList<String>();
        queue.add(head);
        while (queue.size() > 0) {
            String[] pos = queue.poll().split("&");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '.';
                queue.add(getStr(x - 1, y));
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '.';
                queue.add(getStr(x, y - 1));
            }
            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                board[x + 1][y] = '.';
                queue.add(getStr(x + 1, y));
            }
            if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
                board[x][y + 1] = '.';
                queue.add(getStr(x, y + 1));
            }
        }
    }
    
    private String getStr(int i, int j) {
        return i + "&" + j;
    }
    
}