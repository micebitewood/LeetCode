/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    
    private ArrayList<TreeNode> genTrees(int l, int r) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            ArrayList<TreeNode> left = genTrees(l, i - 1);
            ArrayList<TreeNode> right = genTrees(i + 1, r);
            for (TreeNode node1: left) {
                for (TreeNode node2: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    res.add(root);
                }
            }
        }
        return res;
    }
}