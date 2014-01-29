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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        calc(root, res);
        return res;
    }
    
    private void calc(TreeNode root, ArrayList<Integer> res) {
        if (root.left != null) {
            calc(root.left, res);
        }
        if (root.right != null) {
            calc(root.right, res);
        }
        res.add(root.val);
    }
}