public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : num) {
            set.add(n);
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            if (set.contains(n)) {
                int left = n - 1;
                int right = n + 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                left++;
                while (set.contains(right)) {
                    right++;
                }
                right--;
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
            }
        }
        return max;
    }
}