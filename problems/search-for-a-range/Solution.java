public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null)
            return res;
        int l = 0;
        int r = A.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (target > A[m])
                l = m + 1;
            else
                r = m;
        }
        if (r < A.length && A[r] == target) {
            res[0] = r;
            l = r;
            r = A.length;
            while (l < r) {
                int m = (l + r) / 2;
                if (target < A[m])
                    r = m;
                else
                    l = m + 1;
            }
            res[1] = l - 1;
        }
        return res;
    }
}