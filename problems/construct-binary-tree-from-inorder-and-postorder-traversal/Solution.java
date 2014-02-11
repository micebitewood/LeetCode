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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int r1 = inorder.length;
        int r2 = postorder.length;
        return build(inorder, 0, r1, postorder, 0, r2);
    }
    
    private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 == r1)
            return null;
        int r = postorder[r2 - 1];
        TreeNode root = new TreeNode(r);
        int i = l1;
        for (; i < r1; i++) {
            if (inorder[i] == r) {
                break;
            }
        }
        root.left = build(inorder, l1, i, postorder, l2, l2 + i - l1);
        root.right = build(inorder, i + 1, r1, postorder, r2 + i - r1, r2 - 1);
        return root;
    }
}