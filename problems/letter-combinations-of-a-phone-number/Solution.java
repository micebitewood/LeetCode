public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        String[] chs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        StringBuilder sb = new StringBuilder();
        getRes(digits, chs, sb, res);
        return res;
    }
    
    private void getRes(String digits, String[] chs, StringBuilder sb, ArrayList<String> res) {
        if (digits == null || digits.isEmpty()) {
            res.add(sb.toString());
            return;
        }
        char ch = digits.charAt(0);
        for (char c: chs[ch - '2'].toCharArray()) {
            sb.append(c);
            getRes(digits.substring(1), chs, sb, res);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}