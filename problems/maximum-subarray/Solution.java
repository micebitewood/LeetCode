public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0)
            return 0;
        int res = A[0];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }
}