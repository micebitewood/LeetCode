public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int dir = 0;
        for (int k = 0; k < m * n; k++) {
            res.add(matrix[i][j]);
            if (dir == 0) {
                j++;
                if (j == n - i) {
                    j--;
                    i++;
                    dir++;
                }
            } else if (dir == 1) {
                i++;
                if (i == m + 1 - n + j) {
                    i--;
                    j--;
                    dir++;
                }
            } else if (dir == 2) {
                j--;
                if (j == m - i - 2) {
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