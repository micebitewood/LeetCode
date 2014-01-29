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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        myFunc(root);
    }
    
    public TreeNode myFunc(TreeNode root) {
        if (root.left == null && root.right == null)
            return root;
        TreeNode ret = root;
        if (root.right != null)
            ret = myFunc(root.right);
        if (root.left != null) {
            TreeNode last = myFunc(root.left);
            if (root.right == null)
                ret = last;
            last.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return ret;
    }
}