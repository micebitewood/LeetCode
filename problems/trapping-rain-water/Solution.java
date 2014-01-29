public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                maxI = i;
            }
        }
        return get(A, 0, maxI, true) + get(A, maxI + 1, A.length, false);
    }
    
    private int get(int[] A, int l, int r, boolean isLeft) {
        int max = 0;
        int maxI = l;
        for (int i = l; i < r; i++) {
            if (isLeft && i < r - 1 && A[i] > A[i + 1] && A[i] > max) {
                max = A[i];
                maxI = i;
            } else if (!isLeft && i > l && A[i] > A[i - 1] && A[i] > max) {
                max = A[i];
                maxI = i;
            }
        }
        if (max == 0)
            return 0;
        int area = 0;
        if (isLeft) {
            area += max * (r - maxI - 1);
            for (int i = maxI + 1; i < r; i++)
                area -= Math.min(A[i], max);
            area += get(A, l, maxI, true);
        } else {
            area += max * (maxI - l);
            for (int i = l; i < maxI; i++)
                area -= Math.min(A[i], max);
            area += get(A, maxI, r, false);
        }
        return area;
    }
}