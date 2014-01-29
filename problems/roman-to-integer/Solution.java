public class Solution {
    public int romanToInt(String s) {
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 13; i++) {
            map.put(strs[i], nums[i]);
        }
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String temp = s.substring(i, i + 2);
                if (map.containsKey(temp)) {
                    res += map.get(temp);
                    i += 2;
                    continue;
                }
            }
            res += map.get(s.substring(i, i + 1));
            i++;
        }
        return res;
    }
}