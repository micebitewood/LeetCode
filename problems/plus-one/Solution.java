public class Solution {
    public int[] plusOne(int[] digits) {
        boolean cf = true;
        int[] res = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (cf) {
                res[i] = digits[i] + 1;
                if (res[i] < 10) {
                    cf = false;
                } else {
                    res[i] = 0;
                }
            } else
                res[i] = digits[i];
        }
        if (cf) {
            res = new int[digits.length + 1];
            res[0] = 1;
        }
        return res;
    }
}