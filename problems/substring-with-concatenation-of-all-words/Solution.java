public class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        res = new ArrayList<Integer>();
        if (L == null || L.length == 0)
            return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i]))
                map.put(L[i], map.get(L[i]) + 1);
            else
                map.put(L[i], 1);
        }
        int length = L[0].length();
        for (int i = 0; i <= S.length() - length * L.length; i++) {
            if (getRes(S.substring(i), L, new HashMap<String, Integer>(map), length))
                res.add(i);
        }
        return res;
    }
    
    private boolean getRes(String s, String[] L, Map<String, Integer> map, int length) {
        int count = 0;
        for (int i = 0; i < s.length(); i += length) {
            String str = s.substring(i, i + length);
            if (map.containsKey(str)) {
                int n = map.get(str);
                if (n > 0) {
                    count++;
                    map.put(str, n - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
            if (count == L.length)
                return true;
        }
        return false;
    }
}