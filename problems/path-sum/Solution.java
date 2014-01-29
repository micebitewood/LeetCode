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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                return true;
            else
                return false;
        }
        if (root.left != null) {
            root.left.val += root.val;
            boolean has = hasPathSum(root.left, sum);
            if (has)
                return true;
        }
        if (root.right != null) {
            root.right.val += root.val;
            boolean has = hasPathSum(root.right, sum);
            if (has)
                return true;
        }
        return false;
    }
}