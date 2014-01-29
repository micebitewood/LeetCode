public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1)))
                arr[i] = true;
            else {
                for (int j = 0; j < i; j++) {
                    if (arr[j] && dict.contains(s.substring(j + 1, i + 1))) {
                        arr[i] = true;
                        break;
                    }
                }
            }
        }
        return arr[arr.length - 1];
    }
}