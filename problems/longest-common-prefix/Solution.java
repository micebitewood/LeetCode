public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";
        if (strs.length == 0)
            return "";
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < Math.min(res.length(), strs[i].length()); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }
}