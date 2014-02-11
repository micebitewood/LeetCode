public class Solution {
    ArrayList<String> res;
    public ArrayList<String> fullJustify(String[] words, int L) {
        res = new ArrayList<String>();
        int start = 0;
        int cur = 0;
        while (cur < words.length) {
            int length = 0;
            for (; cur < words.length; cur++) {
                if (length + words[cur].length() <= L) {
                    length += words[cur].length() + 1;
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            if (cur == words.length) {
                for (int i = start + 1; i < cur; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < L; i++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            } else {
                length -= cur - start;
                length = L - length;
                for (int i = start + 1; i < cur; i++) {
                    int spaces = length / (cur - i);
                    if (length % (cur - i) != 0)
                        spaces++;
                    length -= spaces;
                    for (int j = 0; j < spaces; j++)
                        sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < L; i++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                start = cur;
            }
        }
        return res;
    }
}