public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int i = 0;
        for (; i < digits.length; i++) {
            if (digits[i] != 9)
                break;
        }
        if (i == digits.length) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        boolean cf = true;
        for (i = digits.length - 1; i >= 0; i--) {
            if (cf) {
                if (digits[i] == 9)
                    digits[i] = 0;
                else {
                    digits[i]++;
                    cf = false;
                }
            } else
                break;
        }
        return digits;
    }
}