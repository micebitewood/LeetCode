public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int a = m - 1;
        int b = n - 1;
        int ind = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[ind] = A[a];
                a--;
            } else {
                A[ind] = B[b];
                b--;
            }
            ind--;
        }
        while (b >= 0) {
            A[ind] = B[b];
            b--;
            ind--;
        }
    }
}