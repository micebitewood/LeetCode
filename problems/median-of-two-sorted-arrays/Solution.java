public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if (length % 2 == 0)
            return (findKth(A, B, 0, A.length, 0, B.length, length / 2 + 1) + findKth(A, B, 0, A.length, 0, B.length, length / 2 )) / 2.;
        else
            return findKth(A, B, 0, A.length, 0, B.length, length / 2 + 1);
    }
    
    private int findKth(int A[], int B[], int l1, int r1, int l2, int r2, int k) {
        if (l1 == r1)
            return B[k - 1 + l2];
        if (l2 == r2)
            return A[k - 1 + l1];
        if (k == 1)
            return Math.min(A[l1], B[l2]);
        int m1 = l1 + Math.min(k / 2, r1 - l1);
        int m2 = l2 + Math.min(k - m1 + l1, r2 - l2);
        m1--;
        m2--;
        if (A[m1] == B[m2])
            return A[m1];
        else if (A[m1] > B[m2])
            return findKth(A, B, l1, r1, m2 + 1, r2, k - (m2 - l2 + 1));
        else
            return findKth(A, B, m1 + 1, r1, l2, r2, k - (m1 - l1 + 1));
    }
}