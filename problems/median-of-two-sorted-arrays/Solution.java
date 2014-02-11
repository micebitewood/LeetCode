public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int l = A.length + B.length;
        if (l % 2 == 0) {
            return (find(A, B, l / 2) + find(A, B, l / 2 + 1)) / 2;
        } else {
            return find(A, B, l / 2 + 1);
        }
    }
    
    private double find(int[] A, int[] B, int k) {
        int l1 = 0;
        int l2 = 0;
        while (k > 0) {
            if (l1 == A.length) {
                return B[l2 + k - 1];
            } else if (l2 == B.length) {
                return A[l1 + k - 1];
            } else if (k == 1) {
                return Math.min(A[l1], B[l2]);
            } else {
                int m1 = Math.min(k / 2, A.length - l1) + l1;
                int m2 = Math.min(k - m1 + l1, B.length - l2) + l2;
                m1--;
                m2--;
                if (A[m1] == B[m2]) {
                    return A[m1];
                } else if (A[m1] > B[m2]) {
                    k -= m2 - l2 + 1;
                    l2 = m2 + 1;
                } else {
                    k -= m1 - l1 + 1;
                    l1 = m1 + 1;
                }
            }
        }
        return Math.min(A[l1], B[l2]);
    }
}