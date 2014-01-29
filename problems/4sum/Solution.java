public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int n1 = num[i];
            for (int j = i + 1; j < num.length - 1; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int n2 = num[j];
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    if (num[left] + num[right] + n1 + n2 == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(n1);
                        list.add(n2);
                        list.add(num[left]);
                        list.add(num[right]);
                        res.add(list);
                        left++;
                        while (left < right && num[left] == num[left - 1])
                            left++;
                    } else if (num[left] + num[right] + n1 + n2 < target) {
                        left++;
                        while (left < right && num[left] == num[left - 1])
                            left++;
                    } else {
                        right--;
                        while (left < right && num[right] == num[right + 1])
                            right--;
                    }
                }
            }
        }
        return res;
    }
}