/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        traverse(root, res);
        return res;
    }
    private void traverse(TreeNode root, ArrayList<Integer> res) {
        if (root.left != null)
            traverse(root.left, res);
        res.add(root.val);
        if (root.right != null)
            traverse(root.right, res);
    }
}