public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        String[] board = new String[n];
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            getRow(board, 0, i, n);
            int j = (1 << i);
            getRes(1, res, l | j, r | j, m | j, board, n);
        }
        return res;
    }
    
    private void getRow(String[] board, int row, int col, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            sb.append(".");
        }
        sb.append("Q");
        for (int i = col + 1; i < n; i++)
            sb.append(".");
        board[row] = sb.toString();
    }
    
    private void getRes(int row, ArrayList<String[]> res, int l, int r, int m, String[] board, int n) {
        if (row == n) {
            String[] newBoard = Arrays.copyOf(board, board.length);
            res.add(newBoard);
            return;
        }
        l = (l << 1);
        r = (r >> 1);
        for (int i = 0; i < n; i++) {
            int j = (1 << i);
            if ((l & j) == 0 && (r & j) == 0 && (m & j) == 0) {
                getRow(board, row, i, n);
                getRes(row + 1, res, l | j, r | j, m | j, board, n);
            }
        }
    }
}