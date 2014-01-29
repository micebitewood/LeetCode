public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }
        int longest = 0;
        boolean[] visited = new boolean[num.length];
        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            if (visited[i])
                continue;
            visited[i] = true;
            int length = 1;
            int right = n;
            int left = n;
            while (map.containsKey(right + 1)) {
                right++;
                visited[map.get(right)] = true;
                length++;
            }
            while (map.containsKey(left - 1)) {
                left--;
                visited[map.get(left)] = true;
                length++;
            }
            if (length > longest)
                longest = length;
        }
        return longest;
    }
}