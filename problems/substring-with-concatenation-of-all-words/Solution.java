public class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        res = new ArrayList<Integer>();
        int l = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : L) {
            l += s.length();
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1);
        }
        for (int i = 0; i <= S.length() - l; i++) {
            if (matches(S.substring(i, i + l), l / L.length, new HashMap<String, Integer>(map)))
                res.add(i);
        }
        return res;
    }
    
    private boolean matches(String s, int l, Map<String, Integer> map) {
        while (!s.isEmpty()) {
            String str = s.substring(0, l);
            s = s.substring(l);
            if (!map.containsKey(str)) {
                return false;
            }
            int c = map.get(str);
            if (c == 0) {
                return false;
            }
            map.put(str, c - 1);
        }
        return true;
    }
}