public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.isEmpty())
            return res;
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 >= i - 1)
                        isPalindrome[j][i] = true;
                    else if (isPalindrome[j + 1][i - 1])
                        isPalindrome[j][i] = true;
                }
            }
        }
        getRes(isPalindrome, s, res, new ArrayList<String>(), 0);
        return res;
    }
    
    private void getRes(boolean[][] isPalindrome, String s, ArrayList<ArrayList<String>> res, ArrayList<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(list));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome[start][end]) {
                    list.add(s.substring(start, end + 1));
                    getRes(isPalindrome, s, res, list, end + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}