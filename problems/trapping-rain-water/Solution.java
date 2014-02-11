public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        int[] left = new int[A.length];
        left[0] = 0;
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1], A[i - 1]);
        }
        int max = A[A.length - 1];
        int res = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            int min = Math.min(max, left[i]);
            if (min > A[i]) {
                res += min - A[i];
            }
            max = Math.max(max, A[i]);
        }
        return res;
    }
}