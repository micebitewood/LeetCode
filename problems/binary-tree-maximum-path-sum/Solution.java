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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        maximize(root);
        return max;
    }
    
    private int maximize(TreeNode root) {
        if (root == null)
            return 0;
        max = Math.max(max, root.val);
        int left = maximize(root.left);
        int right = maximize(root.right);
        max = Math.max(max, left + root.val);
        max = Math.max(max, right + root.val);
        max = Math.max(max, left + right + root.val);
        return Math.max(root.val, Math.max(left, right) + root.val);
    }
}