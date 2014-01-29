public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int blue = A.length - 1;
        int i = 0;
        while (i <= blue) {
            if (A[i] == 0) {
                if (i == red) {
                    i++;
                    red++;
                } else {
                    A[i] = A[red];
                    A[red] = 0;
                    red++;
                }
            } else if (A[i] == 2) {
                if (i == blue)
                    break;
                A[i] = A[blue];
                A[blue] = 2;
                blue--;
            } else
                i++;
        }
    }
}