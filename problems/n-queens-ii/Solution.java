public class Solution {
    public int totalNQueens(int n) {
        int l = 0;
        int r = 0;
        int m = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = (1 << i);
            count += getRes(n - 1, l | j, r | j, m | j, n);
        }
        return count;
    }
    private int getRes(int count, int l, int r, int m, int n) {
        if (count == 0)
            return 1;
        l = (l << 1);
        r = (r >> 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = (1 << i);
            if ((l & j) == 0 && (r & j) == 0 && (m & j) == 0)
                res += getRes(count - 1, l | j, r | j, m | j, n);
        }
        return res;
    }
}