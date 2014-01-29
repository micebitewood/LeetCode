public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= num.length; i++) {
            add(num, 0, i, res, new ArrayList<Integer>());
        }
        return res;
    }
    
    private void add(int[] num, int start, int count, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if (count == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i == start || num[i] != num[i - 1]) {
                list.add(num[i]);
                add(num, i + 1, count - 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}