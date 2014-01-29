public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        restore(s, res, new StringBuilder(), 0);
        return res;
    }
    
    private void restore(String s, ArrayList<String> res, StringBuilder sb, int count) {
        if (s.length() > (4 - count) * 3)
            return;
        if (s.length() < 4 - count)
            return;
        int start = sb.length();
        if (count == 3) {
            if (s.charAt(0) == '0' && s.length() > 1)
                return;
            if (Integer.parseInt(s) > 255)
                return;
            sb.append(s);
            res.add(sb.toString());
            sb.delete(start, sb.length());
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (i > s.length())
                break;
            if (s.charAt(0) == '0' && i > 1)
                break;
            String num = s.substring(0, i);
            if (Integer.parseInt(num) > 255)
                break;
            sb.append(num + ".");
            restore(s.substring(i), res, sb, count + 1);
            sb.delete(start, sb.length());
        }
    }
}