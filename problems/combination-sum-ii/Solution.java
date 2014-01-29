public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        getRes(num, 0, target, new ArrayList<Integer>());
        return res;
    }
    
    private void getRes(int[] num, int start, int target, ArrayList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1])
                continue;
            if (num[i] > target)
                break;
            list.add(num[i]);
            getRes(num, i + 1, target - num[i], list);
            list.remove(list.size() - 1);
        }
    }
}