public class Solution {
    public String countAndSay(int n) {
        String num = "1";
        while (n > 1) {
            int i = 1;
            int start = 0;
            StringBuilder sb = new StringBuilder();
            while (i < num.length()) {
                if (num.charAt(i) != num.charAt(i - 1)) {
                    sb.append(i - start);
                    sb.append(num.charAt(start));
                    start = i;
                }
                i++;
            }
            sb.append(i - start);
            sb.append(num.charAt(start));
            num = sb.toString();
            n--;
        }
        return num;
    }
}