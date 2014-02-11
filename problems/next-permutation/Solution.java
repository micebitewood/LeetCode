public class Solution {
    public void nextPermutation(int[] num) {
        int r = num.length - 1;
        while (r > 0 && num[r - 1] >= num[r]) {
            r--;
        }
        if (r == 0) {
            Arrays.sort(num);
            return;
        }
        int l = r - 1;
        while (r < num.length && num[r] > num[l]) {
            r++;
        }
        r--;
        int t = num[l];
        num[l] = num[r];
        num[r] = t;
        Arrays.sort(num, l + 1, num.length);
    }
}