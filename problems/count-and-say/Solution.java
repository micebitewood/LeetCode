public class Solution {
    public String countAndSay(int n) {
        return countAndSay("1", n);
    }
    
    private String countAndSay(String num, int count) {
        if (count == 1)
            return num;
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
        return countAndSay(sb.toString(), count - 1);
    }
}