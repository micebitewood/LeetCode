public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        
        int length = s1.length();
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s1.charAt(i);
            arr[c - 'a']++;
            c = s2.charAt(i);
            arr[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        for (int i = 1; i < length; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            s21 = s2.substring(0, length - i);
            s22 = s2.substring(length - i);
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }
        return false;
    }
}