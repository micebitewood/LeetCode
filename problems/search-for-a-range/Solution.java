public class Solution {
    int[] res;
    public int[] searchRange(int[] A, int target) {
        res = new int[2];
        res[0] = A.length;
        res[1] = -1;
        search(A, 0, A.length, target);
        if (res[1] == -1)
            res[0] = -1;
        return res;
    }
    
    private void search(int[] A, int l, int r, int target) {
        if (l == r)
            return;
        int m = (l + r) / 2;
        if (A[m] == target) {
            res[0] = Math.min(res[0], m);
            res[1] = Math.max(res[1], m);
            if (A[l] == target) {
                res[0] = Math.min(res[0], l);
            } else {
                search(A, l, m, target);
            }
            if (A[r - 1] == target) {
                res[1] = Math.max(res[1], r - 1);
            } else {
                search(A, m + 1, r, target);
            }
        } else if (A[m] > target) {
            search(A, l, m, target);
        } else {
            search(A, m + 1, r, target);
        }
    }
}