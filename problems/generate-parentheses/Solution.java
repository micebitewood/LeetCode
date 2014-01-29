public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        getRes(n, n, sb, res);
        return res;
    }
    
    private void getRes(int left, int right, StringBuilder sb, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        int start = sb.length();
        if (left > 0) {
            sb.append('(');
            getRes(left - 1, right, sb, res);
            sb.delete(start, start + 1);
        }
        if (right > left) {
            sb.append(')');
            getRes(left, right - 1, sb, res);
            sb.delete(start, start + 1);
        }
    }
}