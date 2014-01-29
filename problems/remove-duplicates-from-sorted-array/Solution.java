public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int left = 1;
        int right = 1;
        while (right < A.length) {
            if (A[right] == A[right - 1]) {
                right++;
            } else {
                A[left] = A[right];
                left++;
                right++;
            }
        }
        return left;
    }
}