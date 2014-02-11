public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int diff = nRows * 2 - 2 - i;
            for (int j = 0; j < s.length(); j += nRows * 2 - 2) {
                if (i == 0 || (i == diff && i + j < s.length())) {
                    sb.append(s.charAt(i + j));
                } else if (i > 0 && i < diff) {
                    if (j + i < s.length()) {
                        sb.append(s.charAt(j + i));
                    }
                    if (j + diff < s.length()) {
                        sb.append(s.charAt(j + diff));
                    }
                }
            }
        }
        return sb.toString();
    }
}