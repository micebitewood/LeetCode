public class Solution {
    public String minWindow(String S, String T) {
        if (T.isEmpty())
            return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
                count++;
            }
            map.put(c, map.get(c) + 1);
        }
        int l = 0;
        int r = 0;
        int min = -1;
        int max = S.length();
        while (r < S.length()) {
            char c = S.charAt(r++);
            if (map.containsKey(c)) {
                int n = map.get(c);
                if (n == 1) {
                    count--;
                }
                map.put(c, n - 1);
                if (count == 0) {
                    while (l < r) {
                        char c2 = S.charAt(l);
                        if (map.containsKey(c2)) {
                            int n2 = map.get(c2);
                            map.put(c2, n2 + 1);
                            if (n2 == 0) {
                                break;
                            }
                        }
                        l++;
                    }
                    if (r - l < max - min) {
                        max = r;
                        min = l;
                    }
                    l++;
                    count++;
                }
            }
        }
        if (min != -1)
            return S.substring(min, max);
        return "";
    }
}