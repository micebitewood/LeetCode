public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int j = i;
            int[] diffs = {2 * nRows - 2 - 2 * i, 2 * i};
            boolean f = true;
            if (diffs[0] == 0)
                f = false;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                if (f) {
                    j += diffs[0];
                    if (diffs[1] != 0)
                        f = false;
                } else {
                    j += diffs[1];
                    if (diffs[0] != 0)
                        f = true;
                }
            }
        }
        return sb.toString();
    }
}