public class Solution {
    public int jump(int[] A) {
        int count = 0;
        int max = 0;
        int i = 0;
        while (max < A.length - 1) {
            int next = max;
            for (;i <= max; i++) {
                if (i + A[i] > next) {
                    next = i + A[i];
                }
            }
            if (next == max)
                return 0;
            count++;
            max = next;
        }
        return count;
    }
}