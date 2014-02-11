public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null)
            return 0;
        if (A.length < 3)
            return A.length;
        int l = 1;
        int r = 1;
        while (r < A.length) {
            A[l] = A[r++];
            if (A[l] == A[l - 1]) {
                while (r < A.length && A[r] == A[r - 1])
                    r++;
            }
            l++;
        }
        return l;
    }
}