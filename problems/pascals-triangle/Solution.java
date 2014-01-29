public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> lastList = list;
            list = new ArrayList<Integer>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                int first = lastList.get(j - 1);
                int second = lastList.get(j);
                list.add(first + second);
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}