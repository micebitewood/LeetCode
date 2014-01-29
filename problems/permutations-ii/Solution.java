public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        permute(num, list, visited, 0);
        return res;
    }
    
    private void permute(int[] num, ArrayList<Integer> list, Set<Integer> visited, int count) {
        if (count == num.length) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < num.length; i++) {
                if (i > 0 && num[i] == num[i - 1] && !visited.contains(i - 1))
                    continue;
                if (visited.contains(i))
                    continue;
                visited.add(i);
                list.add(num[i]);
                permute(num, list, visited, count + 1);
                list.remove(list.size() - 1);
                visited.remove(i);
            }
        }
    }
}