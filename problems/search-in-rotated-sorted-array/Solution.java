public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        return binarySearch(A, 0, A.length, target);
    }
    
    private int binarySearch(int[] A, int l, int r, int target) {
        if (l == r)
            return -1;
        int m = (l + r) / 2;
        if (A[m] == target)
            return m;
        if (A[m] > A[l]) {
            if (target < A[m] && target >= A[l])
                return binarySearch(A, l, m, target);
            else
                return binarySearch(A, m + 1, r, target);
        } else {
            if (target >= A[l] || target < A[m]) {
                return binarySearch(A, l, m, target);
            } else {
                return binarySearch(A, m + 1, r, target);
            }
        }
    }
}