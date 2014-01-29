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
        else if (A[l] < A[r - 1]) {
            if (target > A[m])
                return binarySearch(A, m + 1, r, target);
            else
                return binarySearch(A, l, m, target);
        } else {
            int p = binarySearch(A, m + 1, r, target);
            if (p == -1)
                p = binarySearch(A, l, m, target);
            return p;
        }
    }
}