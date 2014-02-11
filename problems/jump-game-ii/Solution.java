public class Solution {
    public int jump(int[] A) {
        if (A.length < 2)
            return 0;
        int cur = 0;
        int jump = 1;
        int next = 0;
        int i = 0;
        while (i <= next && next < A.length - 1) {
            if (i > cur) {
                cur = next;
                jump++;
            }
            next = Math.max(A[i] + i, next);
            i++;
        }
        return jump;
    }
    
}