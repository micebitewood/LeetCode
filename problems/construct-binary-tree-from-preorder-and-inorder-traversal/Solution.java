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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0)
            return null;
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 == r1)
            return null;
        int rootVal = preorder[l1];
        int ind;
        for (ind = l2; ind < r2; ind++) {
            if (inorder[ind] == rootVal)
                break;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, l1 + 1, ind - l2 + l1 + 1, l2, ind);
        root.right = build(preorder, inorder, ind + 1 - r2 + r1, r1, ind + 1, r2);
        return root;
    }
}