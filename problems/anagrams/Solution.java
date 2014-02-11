public class Solution {
    ArrayList<String> res;
    public ArrayList<String> anagrams(String[] strs) {
        res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.addAll(map.get(key));
            }
        }
        return res;
    }
}