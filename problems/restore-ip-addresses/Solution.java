public class Solution {
    ArrayList<String> res;
    public ArrayList<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        restore(s, new StringBuilder(), 0);
        return res;
    }
    
    private void restore(String s, StringBuilder sb, int count) {
        int l = s.length();
        if (l + count * 3 > 12 || l + count < 4) {
            return;
        }
        if (count == 3 && Integer.parseInt(s) < 256) {
            if (s.charAt(0) != '0' || s.equals("0")) {
                res.add(sb.toString() + s);
            }
        } else {
            int start = sb.length();
            for (int i = 1; i <= Math.min(3, s.length()); i++) {
                int num = Integer.parseInt(s.substring(0, i));
                if (num < 256 && (s.charAt(0) != '0' || i == 1)) {
                    sb.append(num + ".");
                    restore(s.substring(i), sb, count + 1);
                    sb.delete(start, start + i + 1);
                }
            }
        }
    }
}