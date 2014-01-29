public class Solution {
    public String minWindow(String S, String T) {
        if (T.isEmpty())
            return "";
        if (S.length() < T.length())
            return "";
        int[] table = new int[256];
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for (char ch : T.toCharArray()) {
            if (table[ch] == 0)
                count++;
            table[ch]++;
            set.add(ch);
        }
        int start = 0;
        int min = 0;
        int max = S.length() + 1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!set.contains(ch))
                continue;
            table[ch]--;
            if (table[ch] == 0)
                count--;
            if (count == 0) {
                ch = S.charAt(start);
                while (!set.contains(ch) || table[ch] < 0) {
                    if (set.contains(ch))
                        table[ch]++;
                    start++;
                    ch = S.charAt(start);
                }
                if (i - start < max - min) {
                    max = i + 1;
                    min = start;
                }
                table[ch]++;
                start++;
                count++;
            }
        }
        if (max - min > S.length())
            return "";
        return S.substring(min, max);
    }
}