public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left)))
                left++;
            while (left < right && !isAlphanumeric(s.charAt(right)))
                right--;
            if (left >= right)
                break;
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        if (c <= '9' && c >= '0')
            return true;
        if (c <= 'z' && c >= 'a')
            return true;
        return false;
    }
}