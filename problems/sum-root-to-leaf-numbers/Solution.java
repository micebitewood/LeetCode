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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int num) {
        int newNum = num * 10 + root.val;
        if (root.left == null && root.right == null)
            return newNum;
        int res = 0;
        if (root.left != null)
            res += sum(root.left, newNum);
        if (root.right != null)
            res += sum(root.right, newNum);
        return res;
    }
}