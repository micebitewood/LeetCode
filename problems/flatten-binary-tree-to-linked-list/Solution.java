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
        if (root != null) {
            getMax(root);
        }
    }
    
    private TreeNode getMax(TreeNode root) {
        TreeNode max = root;
        if (root.left != null) {
            max = getMax(root.left);
            max.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (max.right != null) {
            max = getMax(max.right);
        }
        return max;
    }
}