public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        getRes(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }
    
    private void getRes(int[] candidates, int start, int target, ArrayList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            int ind = list.size();
            while (num <= target) {
                list.add(candidates[i]);
                getRes(candidates, i + 1, target - num, list);
                num += candidates[i];
            }
            for (int j = list.size() - 1; j >= ind; j--)
                list.remove(j);
        }
    }
}