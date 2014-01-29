public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return haystack;
        int[] pattern = new int[needle.length() + 1];
        int ind = 0;
        for (int i = 2; i < pattern.length; i++) {
            while (ind > 0 && needle.charAt(ind) != needle.charAt(i - 1)) {
                ind = pattern[ind];
            }
            if (needle.charAt(ind) == needle.charAt(i - 1))
                ind++;
            pattern[i] = ind;
        }
        ind = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (ind > 0 && haystack.charAt(i) != needle.charAt(ind)) {
                ind = pattern[ind];
            }
            if (haystack.charAt(i) == needle.charAt(ind))
                ind++;
            if (ind == needle.length())
                return haystack.substring(i - needle.length() + 1);
        }
        return null;
    }
}