public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                arr[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (arr[j] && dict.contains(s.substring(j + 1, i + 1))) {
                        arr[i] = true;
                        break;
                    }
                }
            }
        }
        if (!arr[arr.length - 1])
            return res;
        StringBuilder sb = new StringBuilder();
        solve(s, dict, sb, res);
        return res;
    }
    
    private void solve(String s, Set<String> dict, StringBuilder sb, ArrayList<String> res) {
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (dict.contains(word)) {
                int start = sb.length();
                sb.append(word + " ");
                if (i == s.length()) {
                    res.add(sb.toString().trim());
                } else {
                    solve(s.substring(i), dict, sb, res);
                }
                sb.delete(start, sb.length());
            }
        }
    }
}