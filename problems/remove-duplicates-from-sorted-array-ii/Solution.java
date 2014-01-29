public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null)
            return 0;
        if (A.length == 0)
            return 0;
        int slow = 1;
        int fast = 1;
        while (fast < A.length) {
            A[slow] = A[fast];
            if (A[slow] == A[slow - 1]) {
                while (fast < A.length && A[fast] == A[fast - 1]) {
                    fast++;
                }
            } else
                fast++;
            slow++;
        }
        return slow;
    }
}