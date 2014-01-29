public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = sort(strs[i]);
            if (!map.containsKey(str))
                map.put(str, new ArrayList<String>());
            map.get(str).add(strs[i]);
        }
        for (String str: map.keySet()) {
            List<String> val = map.get(str);
            if (val.size() > 1)
                res.addAll(val);
        }
        return res;
    }
    
    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}