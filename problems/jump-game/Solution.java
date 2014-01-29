public class Solution {
    public boolean canJump(int[] A) {
        if (A == null)
            return false;
        int length = A.length;
        if (length == 0)
            return false;
        int right = 0;
        for (int i = 0; i < length; i++) {
            if (right >= A.length - 1)
                return true;
            if (i <= right && A[i] > 0) {
                right = Math.max(right, i + A[i]);
            } else if (i > right)
                return false;
        }
        return false;
    }
}