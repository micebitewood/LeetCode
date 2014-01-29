public class Solution {
    public int minCut(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - 1 <= j + 1) {
                        isPalindrome[j][i] = true;
                    } else if (isPalindrome[j + 1][i - 1]) {
                        isPalindrome[j][i] = true;
                    }
                }
            }
        }
        if (isPalindrome[0][length - 1])
            return 0;
        int[] nums = new int[length];
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i - 1] + 1;
            if (isPalindrome[0][i])
                nums[i] = 0;
            else
                for (int j = 0; j < i - 1; j++) {
                    if (nums[j] + 1 < nums[i] && isPalindrome[j + 1][i])
                        nums[i] = nums[j] + 1;
                }
        }
        return nums[length - 1];
    }
}