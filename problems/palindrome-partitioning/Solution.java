public class Solution {
    ArrayList<ArrayList<String>> res;
    public ArrayList<ArrayList<String>> partition(String s) {
        res = new ArrayList<ArrayList<String>>();
        if (s.isEmpty())
            return res;
        int l = s.length();
        boolean[][] palindrome = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            palindrome[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i - 1 || palindrome[j + 1][i - 1]) {
                        palindrome[j][i] = true;
                    }
                }
            }
        }
        getRes(palindrome, s, 0, new LinkedList<String>());
        return res;
    }
    
    private void getRes(boolean[][] palindrome, String s, int start, Deque<String> stack) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(stack));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (palindrome[start][i]) {
                String str = s.substring(start, i + 1);
                stack.addLast(str);
                getRes(palindrome, s, i + 1, stack);
                stack.pollLast();
            }
        }
    }
}