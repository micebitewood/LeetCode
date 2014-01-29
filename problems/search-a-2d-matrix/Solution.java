public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        for (int i = 0; i < m; i++) {
            if (target == matrix[i][n - 1])
                return true;
            if (target < matrix[i][n - 1]) {
                return binarySearch(matrix[i], target, 0, n);
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] arr, int target, int l, int r) {
        if (l == r)
            return false;
        int mid = (l + r) / 2;
        if (arr[mid] == target)
            return true;
        else if (arr[mid] > target)
            return binarySearch(arr, target, l, mid);
        else
            return binarySearch(arr, target, mid + 1, r);
    }
}