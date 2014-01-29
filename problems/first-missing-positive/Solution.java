public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;
        int length = A.length;
        int i = 0;
        while (i < length) {
            if (A[i] <= length && A[i] > 0) {
                int t = A[i];
                if (A[t - 1] == t) {
                    i++;
                    continue;
                }
                A[i] = A[t - 1];
                A[t - 1] = t;
            } else
                i++;
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return i + 1;
    }
}