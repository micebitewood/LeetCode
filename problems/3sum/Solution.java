public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int n1 = num[i];
            if (n1 > 0)
                break;
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int val = num[left] + num[right];
                if (val == - n1) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(n1);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);
                    left++;
                    while (left < right && num[left] == num[left - 1])
                        left++;
                } else if (val > -n1) {
                    right--;
                    while (left < right && right < num.length - 1 && num[right] == num[right + 1])
                        right--;
                } else {
                    left++;
                    while (left < right && num[left] == num[left - 1])
                        left++;
                }
            }
        }
        return res;
    }
}