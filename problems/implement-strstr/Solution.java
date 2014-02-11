public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return haystack;
        int[] pattern = new int[needle.length()];
        int count = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (count != 0 && needle.charAt(count) != needle.charAt(i)) {
                count = pattern[count - 1];
            }
            if (needle.charAt(i) == needle.charAt(count))
                pattern[i] = ++count;
        }
        count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (count != 0 && haystack.charAt(i) != needle.charAt(count)) {
                count = pattern[count - 1];
            }
            if (haystack.charAt(i) == needle.charAt(count))
                count++;
            if (count == needle.length()) {
                return haystack.substring(i - count + 1);
            }
        }
        return null;
    }
}