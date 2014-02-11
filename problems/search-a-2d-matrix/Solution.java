public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                int l = 0;
                int r = n;
                int[] arr = matrix[i];
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (arr[mid] == target) {
                        return true;
                    } else if (arr[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                return false;
            }
        }
        return false;
    }
}