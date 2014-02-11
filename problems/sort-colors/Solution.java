public class Solution {
    public void sortColors(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int cur = 0;
        while (cur <= r) {
            if (A[cur] == 0) {
                A[cur] = A[l];
                A[l] = 0;
                l++;
                cur++;
            } else if (A[cur] == 2) {
                A[cur] = A[r];
                A[r] = 2;
                r--;
            } else {
                cur++;
            }
        }
    }
}