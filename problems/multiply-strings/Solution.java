public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int cf = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int ind = i + j + 1;
                int n = n1 * n2 + cf + res[ind];
                cf = n / 10;
                n %= 10;
                res[ind] = n;
            }
            if (cf > 0) {
                res[i] = cf;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0)
            i++;
        while (i < res.length) {
            sb.append(res[i++]);
        }
        return sb.toString();
    }
}