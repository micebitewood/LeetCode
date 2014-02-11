public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            int n = num1.charAt(i) - '0';
            int cf = 0;
            for (int j = l2 - 1; j >= 0; j--) {
                int m = num2.charAt(j) - '0';
                int k = i + j + 1;
                res[k] += n * m + cf;
                cf = res[k] / 10;
                res[k] %= 10;
            }
            res[i] = cf;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l1 + l2; i++) {
            if (sb.length() == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}