public class Solution {
    public String getPermutation(int n, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return get(n, k, set, "");
    }
    private String get(int count, int num, Set<Integer> set, String res) {
        if (count == 1) {
            int i = 1;
            while (set.contains(i))
                i++;
            return res + i;
        }
        else {
            int base = 1;
            for (int i = 2; i < count; i++) {
                base *= i;
            }
            int i = 1;
            while (set.contains(i))
                i++;
            while (num > base) {
                i++;
                while (set.contains(i)) {
                    i++;
                }
                num -= base;
            }
            set.add(i);
            return get(count - 1, num, set, res + i);
        }
    }
}