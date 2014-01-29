public class Solution {
    public boolean search(int[] A, int target) {
        return binarySearch(A, 0, A.length, target);
    }
    
    private boolean binarySearch(int[] A, int left, int right, int target) {
        if (left == right)
            return false;
        int mid = (left + right) / 2;
        if (A[mid] == target)
            return true;
        if (A[left] < A[right - 1]) {
            if (A[mid] < target)
                return binarySearch(A, mid + 1, right, target);
            else
                return binarySearch(A, left, mid, target);
        } else {
            return binarySearch(A, left, mid, target) | binarySearch(A, mid + 1, right, target);
        }
    }
}