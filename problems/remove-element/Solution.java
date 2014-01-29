public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] == elem) {
                A[left] = A[right];
                right--;
            } else {
                left++;
            }
        }
        if (A[left] == elem)
            return left;
        else
            return left + 1;
    }
}