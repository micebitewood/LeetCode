public class Solution {
    public boolean canJump(int[] A) {
        if (A.length < 2)
            return true;
        int cur = 0;
        int r = 0;
        while (cur <= r) {
            if (r >= A.length - 1)
                return true;
            r = Math.max(r, A[cur] + cur);
            cur++;
        }
        return false;
    }
}