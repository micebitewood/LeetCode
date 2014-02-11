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
        int r1 = preorder.length;
        int r2 = inorder.length;
        return build(preorder, inorder, 0, r1, 0, r2);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 == r1)
            return null;
        int r = preorder[l1];
        int i = l2;
        for (; i < r2; i++) {
            if (inorder[i] == r) {
                break;
            }
        }
        TreeNode root = new TreeNode(r);
        root.left = build(preorder, inorder, l1 + 1, l1 + 1 + i - l2, l2, i);
        root.right = build(preorder, inorder, r1 + i + 1 - r2, r1, i + 1, r2);
        return root;
    }
}