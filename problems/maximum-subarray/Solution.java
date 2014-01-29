public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null)
            return 0;
        int length = A.length;
        if (length == 0)
            return 0;
        int i = 0;
        int max = A[0];
        for (; i < length; i++) {
            if (A[i] > 0)
                break;
            if (A[i] > max)
                max = A[i];
        }
        if (i == length)
            return max;
        int sum = 0;
        max = 0;
        for (i = 0; i < length; i++) {
            if (sum + A[i] < 0) {
                sum = 0;
            } else {
                sum += A[i];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}