public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2)
            return false;
        if (s1.equals(s2))
            return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < l1; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        for (int i = 1; i < l1; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, l1);
            if ((isScramble(s11, s2.substring(0, i)) && isScramble(s12, s2.substring(i, l1))) || (isScramble(s11, s2.substring(l1 - i, l1)) && isScramble(s12, s2.substring(0, l1 - i))))
                return true;
        }
        return false;
    }
    
}