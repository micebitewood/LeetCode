public class Solution {
    public String getPermutation(int n, int k) {
        Set<Integer> used = new HashSet<Integer>();
        return getRes(n, k, used);
    }
    
    private String getRes(int n, int k, Set<Integer> used) {
        int count = 1;
        for (int i = 2; i < n - used.size(); i++) {
            count *= i;
        }
        int m = 1;
        while (used.contains(m))
            m++;
        if (used.size() == n - 1)
            return String.valueOf(m);
        while (count < k) {
            k -= count;
            m++;
            while (used.contains(m)) {
                m++;
            }
        }
        used.add(m);
        return m + getRes(n, k, used);
    }
}