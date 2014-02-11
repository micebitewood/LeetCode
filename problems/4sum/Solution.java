public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int n1 = num[i];
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int n2 = num[j];
                int t = target - n1 - n2;
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    int n3 = num[l];
                    int n4 = num[r];
                    if (n3 + n4 == t) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(n1);
                        list.add(n2);
                        list.add(n3);
                        list.add(n4);
                        res.add(list);
                        while (l < r && num[l] == n3) {
                            l++;
                        }
                        while (l < r && num[r] == n4) {
                            r--;
                        }
                    } else if (n3 + n4 < t) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}