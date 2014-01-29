public class Solution {
    public int searchInsert(int[] A, int target) {
        return search(A, 0, A.length, target);
    }
    
    private int search(int[] A, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] == target)
                return m;
            else if (A[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}