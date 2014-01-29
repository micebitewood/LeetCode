public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int j = 0;
        int dir = 0;
        for (int m = 1; m <= n * n; m++) {
            res[i][j] = m;
            if (dir == 0) {
                j++;
                if (j == n - i) {
                    j--;
                    i++;
                    dir++;
                }
            }
            else if (dir == 1) {
                i++;
                if (i == j + 1) {
                    i--;
                    j--;
                    dir++;
                }
            }
            else if (dir == 2) {
                j--;
                if (j == n - i - 2) {
                    j++;
                    i--;
                    dir++;
                }
            } else {
                i--;
                if (i == j) {
                    i++;
                    j++;
                    dir = 0;
                }
            }
        }
        return res;
    }
}