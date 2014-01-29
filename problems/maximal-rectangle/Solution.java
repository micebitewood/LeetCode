public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null)
            return 0;
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    table[i][j] = 0;
                else if (j > 0)
                    table[i][j] = table[i][j - 1] + 1;
                else
                    table[i][j] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int up = i;
                int down = i;
                int val = table[i][j];
                if (val != 0) {
                    while (true) {
                        boolean b1 = false;
                        boolean b2 = false;
                        if (up - 1 >= 0 && table[up - 1][j] >= val) {
                            up--;
                            b1 = true;
                        }
                        if (down + 1 < m && table[down + 1][j] >= val) {
                            down++;
                            b2 = true;
                        }
                        if (!b1 && !b2)
                            break;
                    }
                    int area = val * (down - up + 1);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }
}