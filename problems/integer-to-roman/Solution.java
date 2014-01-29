public class Solution {
    public String intToRoman(int num) {
        String[] c = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] i = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i.length; j++) {
            while (num >= i[j]) {
                sb.append(c[j]);
                num -= i[j];
            }
        }
        return sb.toString();
    }
}