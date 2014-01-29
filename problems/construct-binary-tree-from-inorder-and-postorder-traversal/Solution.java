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
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)
            return null;
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
        if (l1 == r1)
            return null;
        int rootVal = postorder[r2 - 1];
        TreeNode root = new TreeNode(rootVal);
        int ind;
        for (ind = l1; ind < r1; ind++) {
            if (inorder[ind] == rootVal)
                break;
        }
        root.left = build(inorder, postorder, l1, ind, l2, l2 + ind - l1);
        root.right = build(inorder, postorder, ind + 1, r1, r2 - r1 + ind, r2 - 1);
        return root;
    }
}